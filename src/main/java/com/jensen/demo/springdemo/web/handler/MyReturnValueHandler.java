/**
 * 
 */
package com.jensen.demo.springdemo.web.handler;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jensen.demo.springdemo.annotation.Liuyali;

/**
 * @author Rocketman
 *
 */
public class MyReturnValueHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
	return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), Liuyali.class) ||
		returnType.hasMethodAnnotation(Liuyali.class));
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
	    NativeWebRequest webRequest) throws Exception {
	mavContainer.setRequestHandled(true);
	
    }

}
