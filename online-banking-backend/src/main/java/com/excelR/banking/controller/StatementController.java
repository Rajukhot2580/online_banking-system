package com.excelR.banking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelR.banking.serviceImpl.AccountServiceImpl;
import com.excelR.banking.serviceImpl.TransactionServiceImpl;

@RestController
@RequestMapping("/banking")
public class StatementController {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	
	@GetMapping("/bankstatement/{accountNumber}")
	public List<Object[]> getBankStatement(@PathVariable long accountNumber)
	{
		return accountServiceImpl.findUserAccountDetailsByAccountNumber(accountNumber);
	}
	
	@GetMapping("/bankbill/{accountNumber}")
    public List<Object[]> getAccountSummary(
        @PathVariable("accountNumber") Long accountNumber,
        @RequestParam("startDate") String startDate,
        @RequestParam("endDate") String endDate) {

        return transactionServiceImpl.getAccountSummary(accountNumber, startDate, endDate);
    }
	
	@GetMapping("/bankhistory/{accountNumber}")
	public List<Object[]> getBankHistory(@PathVariable long accountNumber, @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate)
	{
		return transactionServiceImpl.getTransactionDetailsByAccountNumberAndDateRange(accountNumber, startDate, endDate);
	}
}
