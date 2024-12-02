
package com.excelR.banking.service;


import java.time.LocalDate;
import java.util.List;

import com.excelR.banking.model.TransactionHistory;

public interface TransactionService {
    TransactionHistory saveTransaction(TransactionHistory transactionHistory);
    void updateAccountBalances(TransactionHistory transactionHistory);
    void updateWithdrawAccountBalances(TransactionHistory transactionHistory);
    void transferAmount(TransactionHistory transactionHistory);
    
    /**
     * Retrieves transaction histories associated with the given account number.
     *
     * @param accountNumber the account number to filter transactions
     * @return a list of matching TransactionHistory records
     */
    public List<Object[]> getTransactionHistoryByAccountNumber(Long accountNumber) ;
    
    List<Object[]> getAccountSummary(Long accountNumber, String startDate, String endDate);
    
    public List<Object[]> getTransactionDetailsByAccountNumberAndDateRange(Long accountNumber, LocalDate startDate, LocalDate endDate);
	   
}
