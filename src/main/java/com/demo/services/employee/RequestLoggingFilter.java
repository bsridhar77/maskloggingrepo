package com.demo.services.employee;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RequestLoggingFilter implements Filter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggingFilter.class);

	@Autowired
	MaskInputHelper maskInputHelper;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException{
		
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		LOGGER.info("RequestInterceptor: REQUEST Intercepted for URI: "
				+ httpServletRequest.getRequestURI());
		RequestWrapper requestWrapper;
		
		try {
			requestWrapper = new RequestWrapper(httpServletRequest);
			LOGGER.info("Payload:" + requestWrapper.getPayload());
			
			LOGGER.info("Masked Payload:" +maskInputHelper.maskInput(requestWrapper.getPayload(),"city","XXX"));
			LOGGER.info("Masked Payload:" +maskInputHelper.maskInput(requestWrapper.getPayload(),"deptno","???"));
			chain.doFilter(requestWrapper, response);
		} catch (Exception e) {
			LOGGER.error("Exception:" ,e);
		}
	}

	@Override
	public void destroy() {
	}
	
	
	
	}

