package com.excelR.banking.dto;

import java.time.LocalDate;

public class AccountTransactionDTO {

    private String accountHolderName;
    private String accountType;
    private long balance;
    private long totalDeposit;
    private long totalWithdraw;
    private long totalDepositReceived;
    private long totalWithdrawReceived;
    private long transactionId;
    private LocalDate transactionDate;
    private String transactionInfo;
    private String transactionType;
    private long sourceAccount;
    private Long destinationAccount;

    // Constructors, Getters, and Setters

    public AccountTransactionDTO() {
    }

    public AccountTransactionDTO(String accountHolderName, String accountType, long balance, long totalDeposit, long totalWithdraw,
                                 long totalDepositReceived, long totalWithdrawReceived, long transactionId, LocalDate transactionDate,
                                 String transactionInfo, String transactionType, long sourceAccount, Long destinationAccount) {
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.totalDeposit = totalDeposit;
        this.totalWithdraw = totalWithdraw;
        this.totalDepositReceived = totalDepositReceived;
        this.totalWithdrawReceived = totalWithdrawReceived;
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionInfo = transactionInfo;
        this.transactionType = transactionType;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    // Getters and Setters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(long totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public long getTotalWithdraw() {
        return totalWithdraw;
    }

    public void setTotalWithdraw(long totalWithdraw) {
        this.totalWithdraw = totalWithdraw;
    }

    public long getTotalDepositReceived() {
        return totalDepositReceived;
    }

    public void setTotalDepositReceived(long totalDepositReceived) {
        this.totalDepositReceived = totalDepositReceived;
    }

    public long getTotalWithdrawReceived() {
        return totalWithdrawReceived;
    }

    public void setTotalWithdrawReceived(long totalWithdrawReceived) {
        this.totalWithdrawReceived = totalWithdrawReceived;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionInfo() {
        return transactionInfo;
    }

    public void setTransactionInfo(String transactionInfo) {
        this.transactionInfo = transactionInfo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public long getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(long sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Long getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Long destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
