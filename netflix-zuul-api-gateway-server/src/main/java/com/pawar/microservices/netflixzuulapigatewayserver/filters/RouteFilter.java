package com.pawar.microservices.netflixzuulapigatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		logger.debug(" -> inside route filter");
		
		return null;
	}

	@Override
	public String filterType() {
		
		return "route";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
