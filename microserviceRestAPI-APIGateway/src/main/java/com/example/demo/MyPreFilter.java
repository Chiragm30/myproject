package com.example.demo;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.HttpHeaders;


import io.netty.handler.codec.http.HttpHeaders.Values;
import reactor.core.publisher.Mono;

@Component
//this prefilter is implements by global filter
public class MyPreFilter implements GlobalFilter{
	
	Logger logger= LoggerFactory.getLogger(MyPreFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		logger.info("filter() method excuted.....");
		
//Access request information
		//using this exchange object we can access complete request of client or user
        ServerHttpRequest request = exchange.getRequest();
		
   HttpHeaders headers = request.getHeaders();
 
   // base on headers we can get the key 
   Set<String> keySet = headers.keySet();
 
   //get the values of each key  
   keySet.forEach(key ->
   {
	 List<String> values =headers.get(key);
	 System.out.println(key + "::" + values);
	 
   } );
   
   //we forward to this request to next filter if other filter is not present then go to routing
   	return chain.filter(exchange);
	}
   
}
