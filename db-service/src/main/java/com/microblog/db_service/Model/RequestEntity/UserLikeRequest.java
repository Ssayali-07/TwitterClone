package com.microblog.db_service.Model.RequestEntity;

import lombok.Data;

@Data
public class UserLikeRequest {
	
//	public String email;
	private Long userId;
	private Long tweetId;

}
