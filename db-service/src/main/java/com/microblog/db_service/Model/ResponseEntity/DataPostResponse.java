package com.microblog.db_service.Model.ResponseEntity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DataPostResponse {

	private String content;
	
	
	private LocalDateTime createdDate;
	
	private int numberOfLikes;


	public DataPostResponse(String content, LocalDateTime createdDate,int numberOfLikes) {
		super();
		this.content = content;
		this.createdDate = createdDate;
		this.numberOfLikes = numberOfLikes;
	}
	
	public DataPostResponse(String content, LocalDateTime createdDate) {
		super();
		this.content = content;
		this.createdDate = createdDate;
		
	}
}
