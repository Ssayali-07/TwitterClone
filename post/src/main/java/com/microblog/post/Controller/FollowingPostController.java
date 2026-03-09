package com.microblog.post.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.post.Model.RequestEntity.FollowingPostRequest;
import com.microblog.post.Service.FollowigPostSvc;

@RestController
@RequestMapping("/followingPost")
public class FollowingPostController {
	
	@Autowired
	FollowigPostSvc followingPostSvcObj;
	
	@PostMapping
	public ResponseEntity followingPostC(@RequestBody FollowingPostRequest followingPostReqObj) {
		return followingPostSvcObj.FollowingPostS(followingPostReqObj);
	}

}
