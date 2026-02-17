package com.microblog.db_service.DataModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TWITTER_POSTS")
public class DataPosts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TWEET_ID")
	private Long tweetId;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="CREATED_DATE")
	private LocalDateTime createdDate;
	
//	@Column(name="USER_ID")
//	private String userId;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	DataUser user;

}
