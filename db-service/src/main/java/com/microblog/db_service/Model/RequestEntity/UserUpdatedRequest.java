package com.microblog.db_service.Model.RequestEntity;

import lombok.Data;

@Data
public class UserUpdatedRequest {
	
	public String name;
	public String username;
	public String password;
	public String email;

}
