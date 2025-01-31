package com.test.reward.rewards.data;

import java.time.LocalDate;

public class RewardData {
	private Long customerId;
    private Double amount;
    private LocalDate transactionDate;
    
    
	public RewardData(Long customerId, Double amount, LocalDate transactionDate) {
		
		this.customerId = customerId;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}
	public RewardData() {

	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
}
