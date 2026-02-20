package com.microblog.db_service.DataModel;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name="TWITTER_USER", uniqueConstraints = @UniqueConstraint(columnNames={"USERNAME"}))
public class DataUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long userId;
	
	
	@Column(name="EMAIL", unique = true)
	private String email;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<DataPosts> posts = new ArrayList<>(); 
	
	@OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
	public List<DataFollowers> followers;
	
	@OneToMany(mappedBy = "following", cascade = CascadeType.ALL)
	public List<DataFollowers> following;
	
//	@OneToMany(mappedBy = "likeId", cascade = CascadeType.ALL)
//	public List<DataLikes> likes;

}
