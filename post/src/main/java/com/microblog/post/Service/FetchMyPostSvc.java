package com.microblog.post.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microblog.post.Model.RequestEntity.FetchMyPostRequest;
import com.microblog.post.Model.RequestEntity.PostRequest;
import com.microblog.post.Model.ResponseEntity.FetchMyPostResponse;
import com.microblog.post.feign.UserDbClient;

@Service
public class FetchMyPostSvc {
	
	@Autowired
	UserDbClient userDbClientObj;
	
	public ResponseEntity FetchpostS(FetchMyPostRequest fetchPostReqObj) {
		
		if(fetchPostReqObj!=null) {
			FetchMyPostResponse fetchPostRes = userDbClientObj.postResObj(fetchPostReqObj);
			return new ResponseEntity(fetchPostRes, HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
	}

}
