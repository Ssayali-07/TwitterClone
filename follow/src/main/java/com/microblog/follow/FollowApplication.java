package com.microblog.follow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

@EnableFeignClients(
		basePackages = "com.microblog.follow.feign"
		)
public class FollowApplication {

	public static void main(String[] args) {
		SpringApplication.run(FollowApplication.class, args);
	}

}
