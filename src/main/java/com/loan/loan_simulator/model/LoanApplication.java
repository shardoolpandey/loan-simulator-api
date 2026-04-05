package com.loan.loan_simulator.model;
import jakarta.persistence.*;
@Entity
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double annualIncome;
    private int creditScore;
    private double existingMonthlyDebt;
    private double requestedLoanAmount;
    private int tenureMonths;

    public LoanApplication() {
    }

    public Long getId() {
        return id;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public double getExistingMonthlyDebt() {
        return existingMonthlyDebt;
    }

    public void setExistingMonthlyDebt(double existingMonthlyDebt) {
        this.existingMonthlyDebt = existingMonthlyDebt;
    }

    public double getRequestedLoanAmount() {
        return requestedLoanAmount;
    }

    public void setRequestedLoanAmount(double requestedLoanAmount) {
        this.requestedLoanAmount = requestedLoanAmount;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    public void setTenureMonths(int tenureMonths) {
        this.tenureMonths = tenureMonths;
    }
}