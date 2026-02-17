package com.microblog.post.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.post.Model.RequestEntity.PostRequest;
import com.microblog.post.Service.PostService;







@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postSvcObj;
	

	
	@PostMapping
	public ResponseEntity postC(@RequestBody PostRequest postRequestObj) {
		return postSvcObj.postS(postRequestObj);
	}

}

