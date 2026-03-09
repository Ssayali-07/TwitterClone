package com.microblog.post.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microblog.post.Model.RequestEntity.FetchMyPostRequest;
import com.microblog.post.Model.RequestEntity.FollowingPostRequest;
import com.microblog.post.Model.ResponseEntity.FetchFollowingResponse;
import com.microblog.post.Model.ResponseEntity.FetchMyPostResponse;
import com.microblog.post.feign.UserDbClient;

@Service
public class FollowigPostSvc {

	@Autowired
	UserDbClient userDbClientObj;
	
public ResponseEntity FollowingPostS(FollowingPostRequest followingPostReqObj) {
		
		if(followingPostReqObj!=null) {
			List<FetchFollowingResponse> followingPostResObj = userDbClientObj.followingPostResObj(followingPostReqObj);
			return new ResponseEntity(followingPostResObj, HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
	}
}
