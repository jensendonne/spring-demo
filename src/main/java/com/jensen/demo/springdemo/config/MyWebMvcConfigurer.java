package com.jensen.demo.springdemo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.jensen.demo.springdemo.web.converter.MyHttpMessageConverter;
import com.jensen.demo.springdemo.web.handler.MyReturnValueHandler;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	
	@Autowired
	private MyHttpMessageConverter converter;
	@Autowired
	private MyReturnValueHandler returnValueHandler;
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(converter);
	}
	
	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
	    handlers.add(returnValueHandler);
	}
	
//	@Bean
//	public MyHttpMessageConverter myHttpMessageConverter() {
//		return new MyHttpMessageConverter();
//	}
}
