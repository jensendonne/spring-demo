/**
 * 
 */
package com.jensen.demo.springdemo.web.handler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jensen.demo.springdemo.annotation.Liuyali;

/**
 * @author Rocketman
 *
 */
public class MyReturnValueHandler implements HandlerMethodReturnValueHandler {

	private ObjectMapper objectMapper;
	
	public MyReturnValueHandler(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), Liuyali.class)
				|| returnType.hasMethodAnnotation(Liuyali.class));
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		mavContainer.setRequestHandled(true);
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		String jsonStr = objectMapper.writeValueAsString(returnValue);
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.getWriter().write(jsonStr);
	}
}
