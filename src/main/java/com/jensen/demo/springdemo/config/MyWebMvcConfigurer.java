package com.jensen.demo.springdemo.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(0, getFastJsonHttpMessageConverter());
	}
	
	private FastJsonHttpMessageConverter getFastJsonHttpMessageConverter() {
		FastJsonHttpMessageConverter fjConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fjConfig = new FastJsonConfig();
		fjConfig.setSerializerFeatures(SerializerFeature.BrowserCompatible);
		ValueFilter valueFilter = new ValueFilter() {
			@Override
			public Object process(Object object, String name, Object value) {
				if (value instanceof BigDecimal) {
					return value.toString();
				}
				return value;
			}
		};
		fjConfig.setSerializeFilters(valueFilter);
		fjConverter.setFastJsonConfig(fjConfig);
		return fjConverter;
	}
}
