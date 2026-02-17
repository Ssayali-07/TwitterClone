package com.microblog.db_service.Model.RequestEntity;



import lombok.Data;

@Data
public class UserPostRequest {
	
	private String content;
	private String email;

}
