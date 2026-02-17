package com.microblog.login_signup.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microblog.login_signup.Model.RequestEntity.LoginRequest;
import com.microblog.login_signup.Model.ResponseEntity.LoginResponse;
import com.microblog.login_signup.Model.ResponseEntity.SignUpResponse;
import com.microblog.login_signup.feign.UserDbClient;

import lombok.Data;

@Data
@Service
public class LoginSvc {

//	@Autowired
//	RestTemplate rest;
	
	@Autowired
	UserDbClient userDbClientObj;
	
	@Autowired
	CommonUtilityDbService commonUtilityObj;

	public ResponseEntity loginS(LoginRequest loginRequestObj) {
		
		if(loginRequestObj!=null) {
			
			
			//LoginResponse loginResponseObj = rest.postForObject("http://localhost:8080/User-DB-Operations/fetch", loginRequestObj, LoginResponse.class);
			LoginResponse loginResponseObj = userDbClientObj.loginResObj(loginRequestObj);
			
			if(loginResponseObj.getEmail()==null) {
				LoginResponse resObjSuccess= new LoginResponse("User not found");
				return new ResponseEntity(resObjSuccess, HttpStatus.OK);
			}else {
				if(commonUtilityObj.PasswordHashing(loginRequestObj.getPassword()).equals(loginResponseObj.getPassword())) {
					LoginResponse resObjSuccess= new LoginResponse("Login Successfull");
					return new ResponseEntity(resObjSuccess, HttpStatus.OK);
				}else{
					LoginResponse resObjSuccess= new LoginResponse("Invalid Password");
					return new ResponseEntity(resObjSuccess, HttpStatus.OK);
				}
			}
			
			
		}else {
			//LoginResponse loginResponseObj = rest.postForObject("http://localhost:8080/User-DB-Operations/fetch", loginRequestObj, LoginResponse.class);
			LoginResponse loginResponseObj = userDbClientObj.loginResObj(loginRequestObj);
			return new ResponseEntity(loginResponseObj, HttpStatus.OK);
		}
		
	}

}
