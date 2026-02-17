package com.microblog.post.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microblog.post.Model.RequestEntity.PostRequest;
import com.microblog.post.Model.ResponseEntity.PostResponse;
import com.microblog.post.feign.UserDbClient;



@Service

public class PostService {
	
	@Autowired
	UserDbClient userDbClientObj;
	
	public ResponseEntity postS(PostRequest postRequestObj) {
		
		if(postRequestObj!=null) {
			PostResponse postResObj= userDbClientObj.postResObj(postRequestObj);
			return new ResponseEntity(postResObj, HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		
	}

}

