package com.microblog.post.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.post.Model.RequestEntity.FetchMyPostRequest;
import com.microblog.post.Model.RequestEntity.PostRequest;
import com.microblog.post.Service.FetchMyPostSvc;

@RestController
@RequestMapping("/fetchPost")
public class FetchMyPostController {
	
	@Autowired
	FetchMyPostSvc fetchPostObj;
	
	@PostMapping
	public ResponseEntity fetchPostC(@RequestBody FetchMyPostRequest fetchPostReqObj) {
		return fetchPostObj.FetchpostS(fetchPostReqObj);
		
	}

}
