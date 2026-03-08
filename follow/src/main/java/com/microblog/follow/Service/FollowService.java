package com.microblog.follow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microblog.follow.Model.RequestEntity.FollowRequest;
import com.microblog.follow.Model.ResponseEntity.FollowResponse;
import com.microblog.follow.feign.UserDbClient;

@Service
public class FollowService {
	
	@Autowired
	UserDbClient userDBobj;
	
	public ResponseEntity followS(FollowRequest followReqObj) {
		if(followReqObj!=null) {
			FollowResponse followResObj = userDBobj.followResObj(followReqObj);
			return new ResponseEntity(followResObj, HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
	}
	

}
