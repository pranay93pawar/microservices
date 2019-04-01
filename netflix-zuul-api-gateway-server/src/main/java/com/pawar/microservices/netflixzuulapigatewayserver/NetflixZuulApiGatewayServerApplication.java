package com.pawar.microservices.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.pawar.microservices.netflixzuulapigatewayserver.filters.ErrorFilter;
import com.pawar.microservices.netflixzuulapigatewayserver.filters.PostFilter;
import com.pawar.microservices.netflixzuulapigatewayserver.filters.PreFilter;
import com.pawar.microservices.netflixzuulapigatewayserver.filters.RouteFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	@Bean
	public PreFilter preFilter() {
		
		return new PreFilter();
	}
	
	@Bean
	public PostFilter postFilter() {
		
		return new PostFilter();
	}
	
	@Bean
	public RouteFilter routeFilter() {
		
		return new RouteFilter();
	}
	
	@Bean
	public ErrorFilter errorFilter() {
		
		return new ErrorFilter();
	}
}
