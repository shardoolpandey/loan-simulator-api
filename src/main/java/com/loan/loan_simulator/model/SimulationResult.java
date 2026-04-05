package com.loan.loan_simulator.model;

import java.util.List;

public class SimulationResult {

    private boolean approved;
    private String riskLevel;

    private double monthlyIncome;
    private double estimatedEMI;
    private double foir;
    private double dti;

    private double financialHealthScore;
    private double defaultRisk;

    private List<String> insights;

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getEstimatedEMI() {
        return estimatedEMI;
    }

    public void setEstimatedEMI(double estimatedEMI) {
        this.estimatedEMI = estimatedEMI;
    }

    public double getFoir() {
        return foir;
    }

    public void setFoir(double foir) {
        this.foir = foir;
    }

    public double getDti() {
        return dti;
    }

    public void setDti(double dti) {
        this.dti = dti;
    }

    public double getFinancialHealthScore() {
        return financialHealthScore;
    }

    public void setFinancialHealthScore(double financialHealthScore) {
        this.financialHealthScore = financialHealthScore;
    }

    public double getDefaultRisk() {
        return defaultRisk;
    }

    public void setDefaultRisk(double defaultRisk) {
        this.defaultRisk = defaultRisk;
    }

    public List<String> getInsights() {
        return insights;
    }

    public void setInsights(List<String> insights) {
        this.insights = insights;
    }
}