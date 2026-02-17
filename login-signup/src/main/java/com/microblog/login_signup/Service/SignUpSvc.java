package com.microblog.login_signup.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microblog.login_signup.Model.RequestEntity.SignUpRequest;
import com.microblog.login_signup.Model.ResponseEntity.SignUpResponse;
import com.microblog.login_signup.feign.UserDbClient;


@Service
public class SignUpSvc {
	
//	@Autowired
//	RestTemplate rest;
	
	@Autowired
	UserDbClient userDbClientObj;
	
	@Autowired
	CommonUtilityDbService commonUtilityObj;
	
	public ResponseEntity signUpS(SignUpRequest signUpReqObj) {
		
		
		//using rest template
//		if(signUpReqObj != null) {
//			signUpReqObj.setPassword(commonUtilityObj.PasswordHashing(signUpReqObj.getPassword()));
//			SignUpResponse signUpResObj = rest.postForObject("http://localhost:8080/User-DB-Operations/insert", signUpReqObj, SignUpResponse.class);
//			
//			return new ResponseEntity(signUpResObj, HttpStatus.OK);
//		}else {
//			return new ResponseEntity(HttpStatus.BAD_REQUEST);
//		}
		
		
//		//using feign
		
		if(signUpReqObj != null) {
		signUpReqObj.setPassword(commonUtilityObj.PasswordHashing(signUpReqObj.getPassword()));
		SignUpResponse signUpResObj = userDbClientObj.signUpResObj(signUpReqObj);
		
		
		return new ResponseEntity(signUpResObj, HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
	}

}
