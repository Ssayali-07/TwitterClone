package com.microblog.post.Model.ResponseEntity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.microblog.post.Model.RequestEntity.FetchMyPostRequest;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class FetchMyPostResponse{
	
	public String msg;
	public List<FetchPostResponseData> posts;

}
