package com.microblog.db_service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microblog.db_service.DataModel.DataLikes;
import com.microblog.db_service.DataModel.DataPosts;
import com.microblog.db_service.DataModel.DataUser;

public interface IDataLikesRepo extends JpaRepository<DataLikes, Long>{

	DataLikes findByUserAndPost(Optional<DataUser> dataUserObjUserId, Optional<DataPosts> dataPostObjTweetId);

}
