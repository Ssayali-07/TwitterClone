package com.microblog.post.Model.ResponseEntity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FetchPostResponseData {
	
	private String content;

	private LocalDateTime createdDate;

}
