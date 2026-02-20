package com.microblog.post.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microblog.post.Model.RequestEntity.FetchMyPostRequest;
import com.microblog.post.Model.RequestEntity.PostRequest;
import com.microblog.post.Model.ResponseEntity.FetchMyPostResponse;
import com.microblog.post.Model.ResponseEntity.PostResponse;



@FeignClient(name="db-service",url="http://localhost:8080",configuration = ClientConfiguration.class )
//@FeignClient(name="db-service",url="http://localhost:8080", path ="/User-DB-Operations",configuration = FeignConfiguration.class)
public interface UserDbClient {
	
	
	
	@PostMapping("/User-DB-Operations/post")
	public PostResponse postResObj(@RequestBody PostRequest postRequestObj);
	
	@PostMapping("/User-DB-Operations/fetch")
	public FetchMyPostResponse postResObj(@RequestBody FetchMyPostRequest fetchPostReqObj);
	

}

