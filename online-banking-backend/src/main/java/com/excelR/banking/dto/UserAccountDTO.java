package com.excelR.banking.dto;

import java.time.LocalDate;

public class UserAccountDTO {
	private long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private String gender;
    private int age;
    private String address;
    private long adharaNumber;
    private String panNumber;
    private long accountNumber;
    private String accountType;
    private LocalDate createdDate;
    
    
	public UserAccountDTO(long customerId, String firstName, String lastName, String email, long phoneNumber,
			String gender, int age, String address, long adharaNumber, String panNumber, long accountNumber,
			String accountType, LocalDate createdDate) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.adharaNumber = adharaNumber;
		this.panNumber = panNumber;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.createdDate = createdDate;
	}


	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getAdharaNumber() {
		return adharaNumber;
	}


	public void setAdharaNumber(long adharaNumber) {
		this.adharaNumber = adharaNumber;
	}


	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}


	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
	
    
    
}
