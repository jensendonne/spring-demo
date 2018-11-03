package com.jensen.demo.springdemo.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

public class BigDecimalSerializer implements ObjectSerializer {
	
	@Override
	public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
			throws IOException {
		BigDecimal value = (BigDecimal) object;
		String text = value.setScale(2).toString();
		serializer.write(text);
	}
}
