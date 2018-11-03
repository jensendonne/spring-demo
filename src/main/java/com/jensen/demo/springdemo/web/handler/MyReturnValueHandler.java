/**
 * 
 */
package com.jensen.demo.springdemo.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.util.Assert;
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
		return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), Liuyali.class)
				|| returnType.hasMethodAnnotation(Liuyali.class));
	}
	
	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		mavContainer.setRequestHandled(true);
		ServletServerHttpRequest inputMessage = createInputMessage(webRequest);
		ServletServerHttpResponse outputMessage = createOutputMessage(webRequest);
		
	}
	
	/**
	 * Create a new {@link HttpInputMessage} from the given {@link NativeWebRequest}.
	 * @param webRequest the web request to create an input message from
	 * @return the input message
	 */
	protected ServletServerHttpRequest createInputMessage(NativeWebRequest webRequest) {
		HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
		Assert.state(servletRequest != null, "No HttpServletRequest");
		return new ServletServerHttpRequest(servletRequest);
	}
	
	/**
	 * Creates a new {@link HttpOutputMessage} from the given {@link NativeWebRequest}.
	 * @param webRequest the web request to create an output message from
	 * @return the output message
	 */
	protected ServletServerHttpResponse createOutputMessage(NativeWebRequest webRequest) {
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		Assert.state(response != null, "No HttpServletResponse");
		return new ServletServerHttpResponse(response);
	}
}
