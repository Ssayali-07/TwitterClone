package com.microblog.login_signup.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microblog.login_signup.Model.RequestEntity.LoginRequest;

import com.microblog.login_signup.Model.RequestEntity.SignUpRequest;
import com.microblog.login_signup.Model.ResponseEntity.LoginResponse;

import com.microblog.login_signup.Model.ResponseEntity.SignUpResponse;

@FeignClient(name = "db-service", url = "http://localhost:8080")
//@FeignClient(name="db-service",url="http://localhost:8080", path ="/User-DB-Operations",configuration = FeignConfiguration.class)
public interface UserDbClient {

	@PostMapping("/User-DB-Operations/insert")
	// @PostMapping("/insert")
	public SignUpResponse signUpResObj(@RequestBody SignUpRequest signUpReqObj);

	@PostMapping("/User-DB-Operations/fetch")
	public LoginResponse loginResObj(@RequestBody LoginRequest loginReqObj);

}
