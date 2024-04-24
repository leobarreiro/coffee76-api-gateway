package com.coffee76.gateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorBean {

	@Bean
	RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes().build();
	}
	
}
