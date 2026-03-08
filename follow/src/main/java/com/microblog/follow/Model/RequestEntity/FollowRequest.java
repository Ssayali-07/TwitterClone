package com.microblog.follow.Model.RequestEntity;

import lombok.Data;

@Data
public class FollowRequest {
	
	public Long follower;
	public Long following;

}
