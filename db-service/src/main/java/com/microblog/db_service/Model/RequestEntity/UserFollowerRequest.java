package com.microblog.db_service.Model.RequestEntity;

import lombok.Data;

@Data
public class UserFollowerRequest {

	public Long follower;
	public Long following;
}
