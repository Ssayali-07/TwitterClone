package com.microblog.db_service.Model.ResponseEntity;

import java.util.List;

import com.microblog.db_service.DataModel.DataPosts;

import lombok.Data;

@Data
public class UserFetchResponse {
	
	public String name;
	public String username;
	public String email;
	public String password;
	//public List<DataPosts> post;
	public List<FetchFollowingPostResponse> posts;
//	public UserFetchResponse(String name, String username, String email, String password) {
//		super();
//		this.name = name;
//		this.username = username;
//		this.email = email;
//		this.password = password;
//	}
	
	
	
	

}
