package com.jensen.demo.springdemo.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(0, getMappingJackson2HttpMessageConverter());
	}

	private MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule();
		// 自定义某种类型的序列化器
		simpleModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);
		objectMapper.registerModule(simpleModule);
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
		return converter;
	}
}
