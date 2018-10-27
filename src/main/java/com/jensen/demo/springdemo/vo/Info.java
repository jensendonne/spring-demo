package com.jensen.demo.springdemo.vo;

import java.math.BigDecimal;

public class Info {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	private BigDecimal amount;
}
