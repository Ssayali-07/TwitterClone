package com.microblog.db_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblog.db_service.Model.RequestEntity.UserFollowerRequest;
import com.microblog.db_service.DataModel.DataPosts;
import com.microblog.db_service.Model.RequestEntity.MyPostRequest;
import com.microblog.db_service.Model.RequestEntity.UserDeleteRequest;
import com.microblog.db_service.Model.RequestEntity.UserFetchRequest;
import com.microblog.db_service.Model.RequestEntity.UserLikeRequest;
import com.microblog.db_service.Model.RequestEntity.UserPostRequest;
import com.microblog.db_service.Model.RequestEntity.UserRequest;
import com.microblog.db_service.Model.RequestEntity.UserUpdatedRequest;
import com.microblog.db_service.Service.UserDBSvc;

@RestController
@RequestMapping("/User-DB-Operations")
public class UserDBCntlr {
	
	@Autowired 
	UserDBSvc userdbsvcobj;
	
	@PostMapping("/insert")
	public ResponseEntity insertUserData(@RequestBody UserRequest userRequestObj) {
		return userdbsvcobj.insertUserDataS(userRequestObj);
	}
	
	@PostMapping("/update")
	public ResponseEntity updateUserData(@RequestBody UserUpdatedRequest userUpdatedRequestObj) {
		return userdbsvcobj.updateUserDataS(userUpdatedRequestObj);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity deleteUserData(@RequestBody UserDeleteRequest userDeleteRequestObj) {
		return userdbsvcobj.deleteUserDataS(userDeleteRequestObj);
		
	}
	
	@PostMapping("/fetch")
	public ResponseEntity fetchUserData(@RequestBody UserFetchRequest userFetchRequestObj) {
		return userdbsvcobj.fetchUserDataS(userFetchRequestObj);
	}
	
	@PostMapping("/post")
	public ResponseEntity postData(@RequestBody UserPostRequest userPostRequestObj) {
		return userdbsvcobj.postDataS(userPostRequestObj);
	}
	
	@PostMapping("/like")
	public ResponseEntity likeDataC(@RequestBody UserLikeRequest userLikeReqObj) {
		return userdbsvcobj.likeDataS(userLikeReqObj);
	}
	
	@PostMapping("/follow")
	public ResponseEntity followDataC(@RequestBody UserFollowerRequest userFollowReqObj) {
		return userdbsvcobj.followDataS(userFollowReqObj);
	}
	
	@PostMapping("/mypost")
	public ResponseEntity<List<DataPosts>> myPostC(@RequestBody MyPostRequest myPostReqObj) {
		//List<DataPosts> posts = userdbsvcobj.myPostS(myPostReqObj.getUserId());
		return userdbsvcobj.myPostS(myPostReqObj);
	}
	
}
