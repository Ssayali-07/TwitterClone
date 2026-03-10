package com.microblog.like;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
		basePackages = "com.microblog.like.feign"
		)
public class LikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikeApplication.class, args);
	}

}
