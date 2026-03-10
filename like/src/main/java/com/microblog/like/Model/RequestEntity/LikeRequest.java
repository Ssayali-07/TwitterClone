package com.microblog.like.Model.RequestEntity;

import lombok.Data;

@Data
public class LikeRequest {
	
	private Long userId;
	private Long tweetId;

}
