package com.jensen.demo.springdemo.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jensen.demo.springdemo.web.handler.MyReturnValueHandler;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
		handlers.add(0, getMyReturnValueHandler());
	}
	
	private MyReturnValueHandler getMyReturnValueHandler() {
		// 若直接把ObjectMapper注册为一个Bean，则会替换全局的ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule();
		// 自定义某种类型的序列化器
		simpleModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);
		objectMapper.registerModule(simpleModule);
		MyReturnValueHandler handler = new MyReturnValueHandler(objectMapper);
		return handler;
	}
}
