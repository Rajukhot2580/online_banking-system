package com.excelR.banking.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelR.banking.model.Biller;
import com.excelR.banking.model.User;
import com.excelR.banking.repository.BillRepository;
import com.excelR.banking.repository.UserRepository;
import com.excelR.banking.service.BillerService;

@Service
public class BillerServiceImpl implements BillerService {

	@Autowired
	BillRepository billrepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<Biller> getAllBills() {
		return billrepository.findAll();
	}

	@Override
	public Biller addBiller(long userId, Biller biller) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			biller.setCustomerId(user.get()); // Set the User as the customer

			try {
				return billrepository.save(biller);
			} catch (Exception e) {
				throw new RuntimeException("Error adding bill: " + e.getMessage());
			}
		} else {
			throw new RuntimeException("User not found with id " + userId);
		}
	}

	@Override
	public List<Object[]> findBillDetailsByCustomerId(long customerId) {
		return billrepository.findBillDetailsByCustomerId(customerId);
	}

	
}
