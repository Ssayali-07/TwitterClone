package com.microblog.db_service.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microblog.db_service.DataModel.DataFollowers;
import com.microblog.db_service.DataModel.DataUser;
import com.microblog.db_service.Model.ResponseEntity.FetchFollowingPostResponse;

@Repository
public interface IDataFollowersRepo extends JpaRepository<DataFollowers, Long>{

	DataFollowers findByFollowerAndFollowing(Optional<DataUser> followerObj, Optional<DataUser> followingObj);

	List<DataFollowers> findByFollower(DataUser user);
	
	@Query(nativeQuery = true , 
			value= "select p from twitter_posts p join twitter_followers f ON  p.user_id = f.following_id where f.follower_id=:followerID")
	List<FetchFollowingPostResponse>  fetchFollowerFeed(@Param("followerID") Long followerID);
	
	
	//select p.user_id,p.tweet_id,p.content,p.created_date from twitter_posts p join twitter_followers f  ON  p.user_id = f.following_id where f.follower_id=?
			

//	List<DataFollowers> findByUserId(Long userId);

}
