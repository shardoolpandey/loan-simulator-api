package com.loan.loan_simulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.loan_simulator.model.LoanApplication;
import com.loan.loan_simulator.model.SimulationResult;
import com.loan.loan_simulator.repository.LoanApplicationRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanSimulationService {

    @Autowired
    private LoanApplicationRepository repository;

    public SimulationResult simulateLoan(LoanApplication app) {

        SimulationResult result = new SimulationResult();
        List<String> insights = new ArrayList<>();

        double monthlyIncome = app.getAnnualIncome() / 12;
        result.setMonthlyIncome(monthlyIncome);

        double emi = (app.getRequestedLoanAmount() * 0.01) /
                (1 - Math.pow(1 + 0.01, -app.getTenureMonths()));

        result.setEstimatedEMI(emi);

        double foir = ((app.getExistingMonthlyDebt() + emi) / monthlyIncome) * 100;
        result.setFoir(foir);

        double dti = (app.getExistingMonthlyDebt() / monthlyIncome) * 100;
        result.setDti(dti);

        boolean approved = true;

        if (app.getCreditScore() < 600) {
            insights.add("CRITICAL: Credit score below acceptable lending policy.");
            approved = false;
        }

        if (foir > 50) {
            insights.add("REJECT: Total obligations exceed 50% of monthly income.");
            approved = false;
        }

        result.setApproved(approved);

        if (app.getCreditScore() > 750 && foir < 30)
            result.setRiskLevel("LOW (Prime Borrower)");
        else if (app.getCreditScore() > 650 && foir < 45)
            result.setRiskLevel("MEDIUM (Sub-Prime Borrower)");
        else
            result.setRiskLevel("HIGH (Risky Borrower)");

        double creditComponent = (app.getCreditScore() / 850.0) * 50;
        double foirComponent = (1 - foir / 100) * 50;

        result.setFinancialHealthScore(Math.max(0, creditComponent + foirComponent));

        if (emi > monthlyIncome * 0.35) {
            insights.add("WARNING: EMI exceeds recommended 35% affordability threshold.");
        }

        if (!approved) {

            double targetIncome = (app.getExistingMonthlyDebt() + emi) / 0.40 * 12;

            insights.add(String.format(
                    "WHAT-IF: Annual income should be at least %.2f for approval.",
                    targetIncome));

            insights.add(
                    "WHAT-IF: Reducing loan amount by 20-30% may improve approval chances.");
        }

        result.setInsights(insights);

        repository.save(app);

        return result;
    }
}