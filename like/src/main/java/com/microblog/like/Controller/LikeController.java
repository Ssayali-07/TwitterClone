package com.microblog.like.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.like.Model.RequestEntity.LikeRequest;
import com.microblog.like.Service.LikeService;



@RestController
@RequestMapping("/like")
public class LikeController {
	
	@Autowired
	LikeService likeSvcObj;
	
	@PostMapping
	public ResponseEntity likeC(@RequestBody LikeRequest likeReqObj) {
		return likeSvcObj.LikeS(likeReqObj);
	}

}
