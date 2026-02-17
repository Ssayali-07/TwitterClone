package com.microblog.db_service.DataModel;

import java.util.Optional;

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
@Table(name="TWITTER_LIKES")
public class DataLikes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TWEET_LIKES")
	private Long likeId;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private DataUser user;
	
	@ManyToOne
	@JoinColumn(name="TWEET_ID")
	private DataPosts post;

}
