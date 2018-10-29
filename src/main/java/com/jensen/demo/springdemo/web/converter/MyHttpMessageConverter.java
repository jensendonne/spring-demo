package com.jensen.demo.springdemo.web.converter;

import java.io.IOException;
import java.lang.annotation.Annotation;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;

import com.jensen.demo.springdemo.annotation.Liuyali;

public class MyHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    @Override
    protected boolean supports(Class<?> clazz) {
	// 只作用于标注了特定注解的类
	Annotation a = clazz.getAnnotation(Liuyali.class);
	return (a != null ? true : false);
    }

    @Override
    public boolean canRead(Class<?> clazz, @Nullable MediaType mediaType) {
	// 只用于写，不用作读
	return false;
    }
    
    @Override
    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
	    throws IOException, HttpMessageNotReadableException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected void writeInternal(Object t, HttpOutputMessage outputMessage)
	    throws IOException, HttpMessageNotWritableException {
	// TODO Auto-generated method stub

    }

}
