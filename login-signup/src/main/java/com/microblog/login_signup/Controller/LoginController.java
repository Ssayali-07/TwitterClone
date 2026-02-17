package com.microblog.login_signup.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.login_signup.Model.RequestEntity.LoginRequest;
import com.microblog.login_signup.Service.LoginSvc;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginSvc loginSvcObj;
	
	@PostMapping
	public ResponseEntity loginC(@RequestBody LoginRequest loginRequestObj) {
		return loginSvcObj.loginS(loginRequestObj);
	}

}
