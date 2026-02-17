package com.microblog.db_service.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microblog.db_service.DataModel.DataFollowers;
import com.microblog.db_service.DataModel.DataPosts;
import com.microblog.db_service.DataModel.DataUser;

public interface IDataFollowersRepo extends JpaRepository<DataFollowers, Long>{

	DataFollowers findByFollowerAndFollowing(Optional<DataUser> followerObj, Optional<DataUser> followingObj);

	List<DataFollowers> findByUserId(Long userId);

}
