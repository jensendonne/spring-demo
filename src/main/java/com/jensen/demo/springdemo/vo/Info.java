package com.jensen.demo.springdemo.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.jensen.demo.springdemo.annotation.Liuyali;

@Liuyali
public class Info {
    private String name;
    @JsonFormat(shape=Shape.STRING)
    private BigDecimal amount;

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
}
