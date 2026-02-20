package com.microblog.db_service.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microblog.db_service.DataModel.DataPosts;

public interface IDataPostsRepo extends JpaRepository<DataPosts, Long>{

	Optional<DataPosts> findById(Long tweetId);

	List<DataPosts> findByUserFollowingIn(List<Long> followingId);

	

}
