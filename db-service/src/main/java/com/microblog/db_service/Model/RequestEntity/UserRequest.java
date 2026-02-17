package com.microblog.db_service.Model.RequestEntity;

import lombok.Data;

@Data
public class UserRequest {
	
	public String name;
	public String username;
	public String email;
	public String password;

}
