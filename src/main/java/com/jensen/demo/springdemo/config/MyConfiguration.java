package com.jensen.demo.springdemo.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

//@Configuration
public class MyConfiguration {

//	@Bean
	public ObjectMapper myObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule();
		// 自定义某种类型的序列化器
		simpleModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);
		objectMapper.registerModule(simpleModule);
		return objectMapper;
	}
}
