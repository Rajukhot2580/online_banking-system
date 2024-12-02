package com.excelR.banking.service;

import java.util.List;

import com.excelR.banking.model.Biller;


public interface BillerService {
	 public Biller addBiller(long userId, Biller biller);
     public List<Biller> getAllBills();
     public List<Object[]> findBillDetailsByCustomerId(long customerId);
}
