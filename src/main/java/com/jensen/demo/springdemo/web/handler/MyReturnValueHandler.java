/**
 * 
 */
package com.jensen.demo.springdemo.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jensen.demo.springdemo.annotation.Liuyali;
import com.jensen.demo.springdemo.web.converter.MyHttpMessageConverter;

/**
 * @author Rocketman
 *
 */
@Component
public class MyReturnValueHandler implements HandlerMethodReturnValueHandler {

//	protected final List<HttpMessageConverter<?>> messageConverters;
//
//	public MyReturnValueHandler(List<HttpMessageConverter<?>> messageConverters) {
//		Assert.notEmpty(messageConverters, "'messageConverters' must not be empty");
//		this.messageConverters = messageConverters;
//	}
	
	@Autowired
	private MyHttpMessageConverter converter;

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), Liuyali.class)
				|| returnType.hasMethodAnnotation(Liuyali.class));
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		mavContainer.setRequestHandled(true);
		// ServletServerHttpRequest inputMessage =
		// createInputMessage(webRequest);
		ServletServerHttpResponse outputMessage = createOutputMessage(webRequest);
//		for (HttpMessageConverter<?> converter : messageConverters) {
//			if (converter instanceof MyHttpMessageConverter) {
//				((MyHttpMessageConverter) converter).write(returnValue, null, outputMessage);
//			}
//			break;
//		}
		converter.write(returnValue, MediaType.APPLICATION_JSON_UTF8, outputMessage);
	}

	/**
	 * Create a new {@link HttpInputMessage} from the given
	 * {@link NativeWebRequest}.
	 * 
	 * @param webRequest
	 *            the web request to create an input message from
	 * @return the input message
	 */
	protected ServletServerHttpRequest createInputMessage(NativeWebRequest webRequest) {
		HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
		Assert.state(servletRequest != null, "No HttpServletRequest");
		return new ServletServerHttpRequest(servletRequest);
	}

	/**
	 * Creates a new {@link HttpOutputMessage} from the given
	 * {@link NativeWebRequest}.
	 * 
	 * @param webRequest
	 *            the web request to create an output message from
	 * @return the output message
	 */
	protected ServletServerHttpResponse createOutputMessage(NativeWebRequest webRequest) {
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		Assert.state(response != null, "No HttpServletResponse");
		return new ServletServerHttpResponse(response);
	}
}
