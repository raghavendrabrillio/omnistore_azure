package com.brillio.omnistore.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.brillio.omnistore.controller.AuthController;
import com.brillio.omnistore.controller.CustomerController;
import com.brillio.omnistore.controller.OrderController;
import com.brillio.omnistore.controller.ReturnsController;

@ControllerAdvice(assignableTypes = { CustomerController.class, AuthController.class, ReturnsController.class,
		OrderController.class })
public class GlobalExceptionHandler implements ResponseBodyAdvice<Object> {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	private static String getStackTrace(Throwable throwable) {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		throwable.printStackTrace(pw);
		return sw.getBuffer().toString();
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleException(Exception ex) {
		LOGGER.error("Exception: " + getStackTrace(ex));
		return new ResponseEntity<>(getStackTrace(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		int status = HttpStatus.OK.value();
		if (response instanceof ServletServerHttpResponse) {
			status = ((ServletServerHttpResponse) response).getServletResponse().getStatus();
		}
		response.setStatusCode(HttpStatus.valueOf(status));
		return body;
	}

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}
}
