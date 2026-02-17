package com.microblog.login_signup.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.microblog.login_signup.Model.RequestEntity.SignUpRequest;
import com.microblog.login_signup.Service.SignUpSvc;

@RestController
@RequestMapping("/signUp")
public class SignUpController {
	
	@Autowired
	SignUpSvc signUpSvcObj;
	
	@PostMapping
	public ResponseEntity signUpC(@RequestBody SignUpRequest signUpReqObj) {
		return signUpSvcObj.signUpS(signUpReqObj);
	}

}
