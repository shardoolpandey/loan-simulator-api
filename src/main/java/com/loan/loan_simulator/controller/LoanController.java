package com.loan.loan_simulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.loan.loan_simulator.model.LoanApplication;
import com.loan.loan_simulator.service.LoanSimulationService;
import com.loan.loan_simulator.model.SimulationResult;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanSimulationService service;

    @PostMapping("/simulate")
    public SimulationResult simulateLoan(@RequestBody LoanApplication app) {
        return service.simulateLoan(app);
    }
}