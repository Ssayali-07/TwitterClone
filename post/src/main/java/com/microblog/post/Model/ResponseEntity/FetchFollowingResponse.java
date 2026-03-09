package com.microblog.post.Model.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class FetchFollowingResponse {

	private String content;

	private LocalDateTime createdDate;

	private int numberOfLikes;
}
