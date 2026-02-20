package com.microblog.db_service.DataModel;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TWITTER_FOLLOWERS")
public class DataFollowers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FOLLOW_ID")
	private Long followId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FOLLOWER_ID")
	private DataUser follower;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FOLLOWING_ID")
	private DataUser following;

}
