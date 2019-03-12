package com.chainsys.model;

import java.time.LocalDate;

public class Transactions {
	private int accountNumber;
	private int id;
	private int pin;
	private String status;
	private LocalDate transactionDate;
	private float amount;
	private User user;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Transactions [accountNumber=" + accountNumber + ", id=" + id
				+ ", pin=" + pin + ", status=" + status + ", transactionDate="
				+ transactionDate + ", amount=" + amount + ", user=" + user
				+ "]";
	}

}
