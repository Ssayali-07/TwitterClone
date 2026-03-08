package com.microblog.follow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.follow.Model.RequestEntity.FollowRequest;
import com.microblog.follow.Service.FollowService;

@RestController
@RequestMapping("/follow")
public class FollowController {
	
	@Autowired
	FollowService followSvcObj;
	
	@PostMapping
	public ResponseEntity followC(@RequestBody FollowRequest followReqObj) {
		return followSvcObj.followS(followReqObj);
	}

}
