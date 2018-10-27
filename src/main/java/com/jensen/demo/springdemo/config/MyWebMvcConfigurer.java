package com.jensen.demo.springdemo.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jensen.demo.springdemo.converter.MyHttpMessageConverter;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MyHttpMessageConverter());
	}
}
