package com.microblog.login_signup.Model.ResponseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {

	public String msg;
	
	public String name;
	public String username;
	public String email;
	public String password;

	public LoginResponse(String msg) {
		super();
		this.msg = msg;
	}
	
}
