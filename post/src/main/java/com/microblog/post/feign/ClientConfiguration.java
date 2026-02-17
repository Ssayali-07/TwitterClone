package com.microblog.post.feign;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.okhttp.OkHttpClient;

public class ClientConfiguration {
	
	@Bean
	public OkHttpClient client() {
		return new OkHttpClient();
				
	}
 
	@Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // Logs headers, body, and metadata
    }

}
