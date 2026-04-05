package com.loan.loan_simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.loan.loan_simulator.model.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

}