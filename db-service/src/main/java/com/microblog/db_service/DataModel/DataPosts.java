package com.microblog.db_service.DataModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private DataUser user;

	public DataPosts(String content, LocalDateTime createdDate) {
		super();
		this.content = content;
		this.createdDate = createdDate;
	}
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="LIKE_ID")
//	private DataLikes likeId;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	public List<DataLikes> likes ;
	
	public DataPosts() {
		// TODO Auto-generated constructor stub
	}
	
	

}
