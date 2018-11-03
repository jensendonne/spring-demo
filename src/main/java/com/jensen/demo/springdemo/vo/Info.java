package com.jensen.demo.springdemo.vo;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.jensen.demo.springdemo.utils.BigDecimalSerializer;

public class Info {
    private String name;
    @JSONField(serializeUsing = BigDecimalSerializer.class)
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
