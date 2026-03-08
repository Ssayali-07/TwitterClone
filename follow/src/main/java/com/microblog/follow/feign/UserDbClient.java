package com.microblog.follow.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microblog.follow.Model.RequestEntity.FollowRequest;
import com.microblog.follow.Model.ResponseEntity.FollowResponse;

@FeignClient(name="db-service", url="http://localhost:8080")
public interface UserDbClient {
	
	@PostMapping("/User-DB-Operations/follow")
	public FollowResponse followResObj(@RequestBody FollowRequest followReqObj);

}
