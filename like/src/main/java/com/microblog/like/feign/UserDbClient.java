package com.microblog.like.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microblog.like.Model.RequestEntity.LikeRequest;
import com.microblog.like.Model.ResponseEntity.LikeResponse;


@FeignClient(name="db-service", url="http://localhost:8080")
public interface UserDbClient {
	
	@PostMapping("/User-DB-Operations/like")
	public LikeResponse likeResObj(@RequestBody LikeRequest likeReqObj);
	

}
