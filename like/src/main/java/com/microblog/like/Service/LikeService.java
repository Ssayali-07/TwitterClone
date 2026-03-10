package com.microblog.like.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microblog.like.Model.RequestEntity.LikeRequest;
import com.microblog.like.Model.ResponseEntity.LikeResponse;
import com.microblog.like.feign.UserDbClient;

@Service
public class LikeService {
	@Autowired
	UserDbClient userdbObj;

	public ResponseEntity LikeS(LikeRequest likeReqObj) {

		if (likeReqObj != null) {
			LikeResponse likeResObj = userdbObj.likeResObj(likeReqObj);
			return new ResponseEntity(likeResObj, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

}
