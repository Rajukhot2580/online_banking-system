package com.excelR.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelR.banking.model.Biller;
import com.excelR.banking.serviceImpl.BillerServiceImpl;

@RestController
@RequestMapping("/banking")
public class BillController {
  
	@Autowired
	BillerServiceImpl billerServiceImpl;
	
	@PostMapping("/addbiller")
	public ResponseEntity<String> addBiller(@RequestParam long userId,@RequestBody Biller biller)
	{
		billerServiceImpl.addBiller(userId,biller);
		return ResponseEntity.ok("added");
	}
	
	@GetMapping("/viewallbills")
	public List<Biller> getAllBills()
	{
		return billerServiceImpl.getAllBills();
	}
	
	@GetMapping("/viewbillsById/{customerId}")
    public List<Object[]> getAllBillDetailsByCustomerId(@PathVariable long customerId) {
        return billerServiceImpl.findBillDetailsByCustomerId(customerId);
    }
}
