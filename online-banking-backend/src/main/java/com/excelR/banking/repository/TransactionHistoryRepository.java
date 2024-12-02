package com.excelR.banking.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.excelR.banking.model.TransactionHistory;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
	
	/**
     * Fetches all transaction histories where the source or destination account matches the given account number.
     *
     * @param accountNumber the account number to filter transactions
     * @return a list of matching TransactionHistory records
     */
	@Query("SELECT th.transactionId AS transactionId, th.amount AS amount, th.transactionDate AS transactionDate, " +
	           "th.transactionInfo AS transactionInfo, th.transactionType AS transactionType, " +
	           "th.destinationAccount.accountNumber AS destinationAccount, th.sourceAccount.accountNumber AS sourceAccount " +
	           "FROM TransactionHistory th " +
	           "WHERE th.sourceAccount.accountNumber = :accountNumber " +
	           "OR th.destinationAccount.accountNumber = :accountNumber")
	    List<Object[]> findTransactionDetailsByAccountNumber(@Param("accountNumber") Long accountNumber);
	    
	    
	    @Query(value = "SELECT " +
	               "(SELECT SUM(th1.amount) " +
	               " FROM transaction_history th1 " +
	               " WHERE th1.transaction_type = 'deposit' " +
	               "   AND th1.source_account = :accountNumber " +
	               "   AND th1.transaction_date BETWEEN :startDate AND :endDate) AS total_deposit, " +
	               "(SELECT SUM(th2.amount) " +
	               " FROM transaction_history th2 " +
	               " WHERE th2.transaction_type = 'withdraw' " +
	               "   AND th2.source_account = :accountNumber " +
	               "   AND th2.transaction_date BETWEEN :startDate AND :endDate) AS total_withdraw, " +
	               "(SELECT SUM(th3.amount) " +
	               " FROM transaction_history th3 " +
	               " WHERE th3.transaction_type IN ('gas', 'water', 'electricity', 'rent', 'mobile') " +
	               "   AND th3.source_account = :accountNumber " +
	               "   AND th3.transaction_date BETWEEN :startDate AND :endDate) AS total_bills " +
	               "FROM transaction_history " +
	               "WHERE source_account = :accountNumber " +
	               "  AND transaction_date BETWEEN :startDate AND :endDate",
	       nativeQuery = true)
	List<Object[]> findAccountSummaryByAccountNumber(
	    @Param("accountNumber") Long accountNumber,
	    @Param("startDate") String startDate,
	    @Param("endDate") String endDate);
    
	
	@Query("SELECT th.transactionId AS transactionId, th.amount AS amount, th.transactionDate AS transactionDate, " +
		       "th.transactionInfo AS transactionInfo, th.transactionType AS transactionType, " +
		       "th.destinationAccount.accountNumber AS destinationAccount, th.sourceAccount.accountNumber AS sourceAccount " +
		       "FROM TransactionHistory th " +
		       "WHERE (th.sourceAccount.accountNumber = :accountNumber " +
		       "OR th.destinationAccount.accountNumber = :accountNumber) " +
		       "AND th.transactionDate BETWEEN :startDate AND :endDate")
		List<Object[]> findTransactionDetailsByAccountNumberAndDateRange(@Param("accountNumber") Long accountNumber, 
		                                                                  @Param("startDate") LocalDate startDate, 
		                                                                  @Param("endDate") LocalDate endDate);

	   
	    
}