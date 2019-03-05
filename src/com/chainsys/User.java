package com.chainsys;

import java.time.LocalDate;

public class User {
	private int accountNumber;
	private String name;
	private String email;
	private String password;
	private LocalDate dateOfBirth;
	private String gender;
	private String city;
	private int pin;
	private int bankBalance;
	private int amount;
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(int bankBalance) {
		this.bankBalance = bankBalance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		try {
		if(pin>=1000&&pin<=9999)
		{
		this.pin = pin;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "User [accountNumber=" + accountNumber + ", name=" + name
				+ ", email=" + email + ", password=" + password
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", city=" + city + ", pin=" + pin + ", bankBalance="
				+ bankBalance + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
	
	
	

}
