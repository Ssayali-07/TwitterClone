package com.microblog.login_signup.Model.RequestEntity;


import lombok.Data;

@Data
public class SignUpRequest {
	
	public String name;
	public String username;
	public String email;
	public String password;

}
