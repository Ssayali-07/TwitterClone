package com.microblog.db_service.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microblog.db_service.DataModel.DataFollowers;
import com.microblog.db_service.DataModel.DataLikes;
import com.microblog.db_service.DataModel.DataPosts;
import com.microblog.db_service.DataModel.DataUser;
import com.microblog.db_service.Model.RequestEntity.FetchFollowingPostRequest;
import com.microblog.db_service.Model.RequestEntity.UserDeleteRequest;
import com.microblog.db_service.Model.RequestEntity.UserFetchRequest;
import com.microblog.db_service.Model.RequestEntity.UserFollowerRequest;
import com.microblog.db_service.Model.RequestEntity.UserLikeRequest;
import com.microblog.db_service.Model.RequestEntity.UserPostRequest;
import com.microblog.db_service.Model.RequestEntity.UserRequest;
import com.microblog.db_service.Model.RequestEntity.UserUpdatedRequest;
import com.microblog.db_service.Model.ResponseEntity.FetchFollowingPostResponse;
import com.microblog.db_service.Model.ResponseEntity.InsertUpdateDeleteResponse;
import com.microblog.db_service.Model.ResponseEntity.UserFetchResponse;
import com.microblog.db_service.Repository.IDataFollowersRepo;
import com.microblog.db_service.Repository.IDataLikesRepo;
import com.microblog.db_service.Repository.IDataPostsRepo;
import com.microblog.db_service.Repository.IDataUserRepo;

import lombok.Data;

@Data
@Service
public class UserDBSvc {

	@Autowired
	IDataUserRepo userRepoObj;

	@Autowired
	IDataPostsRepo dataRepoObj;

	@Autowired
	IDataLikesRepo likeRepoObj;
	
	@Autowired
	IDataFollowersRepo followerRepoObj;

	public ResponseEntity insertUserDataS(UserRequest userRequestObj) {

		if (userRequestObj != null && userRequestObj.getEmail() != null) {

			try {

				DataUser dataUserObj1 = userRepoObj.findByEmail(userRequestObj.getEmail());
				DataUser dataUserObj2 = userRepoObj.findByUsername(userRequestObj.getUsername());

				if (dataUserObj1 != null) {
//					Map<String, String> responseMap = new HashMap<>();
//
//					responseMap.put("msg", "User Already Exist");
//
//					return new ResponseEntity<>(responseMap, HttpStatus.OK);
					
					InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("User Already Exist");
					return new ResponseEntity(res, HttpStatus.OK);
					
//					return ResponseEntity.ok("User Already Exist");
				} else if (dataUserObj2 != null) {
					
					
					InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("UserName Not Available");
					return new ResponseEntity(res, HttpStatus.OK);
				}

				else {

					DataUser dataUserObj = new DataUser();
					dataUserObj.setEmail(userRequestObj.getEmail());
					dataUserObj.setName(userRequestObj.getName());
					dataUserObj.setUsername(userRequestObj.getUsername());
					dataUserObj.setPassword(userRequestObj.getPassword());

					userRepoObj.save(dataUserObj);
					
					InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("User Created");
					return new ResponseEntity(res, HttpStatus.OK);

					
				}

			} catch (Exception e) {
				// TODO: handle exception
				
				InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("Something went Wrong");
				return new ResponseEntity(res, HttpStatus.OK);
				

//			throw new Exception("Something went Wrong", e);

			}
		} else {
			InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("Something went Wrong");
			return new ResponseEntity(res, HttpStatus.OK);
		}

	}

	public ResponseEntity updateUserDataS(UserUpdatedRequest userUpdatedRequestObj) {

		if (userUpdatedRequestObj != null && userUpdatedRequestObj.getEmail() != null) {

			try {
				DataUser dataUserUpdateObj = userRepoObj.findByEmail(userUpdatedRequestObj.getEmail());

				if (dataUserUpdateObj != null) {
					dataUserUpdateObj.setName(userUpdatedRequestObj.getName());
					dataUserUpdateObj.setUsername(userUpdatedRequestObj.getUsername());
					dataUserUpdateObj.setPassword(userUpdatedRequestObj.getPassword());

					userRepoObj.save(dataUserUpdateObj);
					
					InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("User Updated");
					return new ResponseEntity(res, HttpStatus.OK);

					
				} else {
					

					InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("User not found");
					return new ResponseEntity(res, HttpStatus.OK);

				}

			} catch (Exception e) {
				// TODO: handle exception

				InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("Something went Wrong");
				return new ResponseEntity(res, HttpStatus.OK);
			}
		} else {
			
			InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("Something went Wrong");
			return new ResponseEntity(res, HttpStatus.OK);
		}

	}

	public ResponseEntity deleteUserDataS(UserDeleteRequest userDeleteRequestObj) {

		if (userDeleteRequestObj != null && userDeleteRequestObj.getEmail() != null) {

			try {
				DataUser dataUserDeleteObj = userRepoObj.findByEmail(userDeleteRequestObj.getEmail());

				if (dataUserDeleteObj != null) {
					userRepoObj.delete(dataUserDeleteObj);
					
					InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("User deleted");
					return new ResponseEntity(res, HttpStatus.OK);

				} else {

					InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("User not found");
					return new ResponseEntity(res, HttpStatus.OK);

				}

			} catch (Exception e) {
				// TODO: handle exception
				InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("Something went Wrong");
				return new ResponseEntity(res, HttpStatus.OK);
			}
		} else {
			InsertUpdateDeleteResponse res = new InsertUpdateDeleteResponse("Something went Wrong");
			return new ResponseEntity(res, HttpStatus.OK);
		}

	}

	public ResponseEntity fetchUserDataS(UserFetchRequest userFetchRequestObj) {

		if (userFetchRequestObj != null && userFetchRequestObj.getEmail() != null) {

			try {

				DataUser dataUserFetchObj = userRepoObj.findByEmail(userFetchRequestObj.getEmail());
				//List<DataPosts> posts = dataUserFetchObj.getPosts();	
				List<FetchFollowingPostResponse> posts = new ArrayList<>();
				for(DataPosts pos : dataUserFetchObj.getPosts()) {
					posts.add(new FetchFollowingPostResponse(pos.getContent(),pos.getCreatedDate()));
				}
				if (dataUserFetchObj != null) {

					UserFetchResponse userFetchResponseObj = new UserFetchResponse();
					userFetchResponseObj.setName(dataUserFetchObj.getName());
					userFetchResponseObj.setUsername(dataUserFetchObj.getUsername());
					userFetchResponseObj.setEmail(dataUserFetchObj.getEmail());
					userFetchResponseObj.setPassword(dataUserFetchObj.getPassword());
					userFetchResponseObj.setPosts(posts);
					return new ResponseEntity<>(userFetchResponseObj, HttpStatus.OK);

				} else {

					Map<String, String> responseMap = new HashMap<>();
					responseMap.put("msg", "User not found");

					return new ResponseEntity<>(responseMap, HttpStatus.OK);

				}

			} catch (Exception e) {
				// TODO: handle exception
				Map<String, String> responseMap = new HashMap<>();

				responseMap.put("msg", "Something went Wrong");

				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			}
		} else {
			Map<String, String> responseMap = new HashMap<>();

			responseMap.put("msg", "Something went Wrong");

			return new ResponseEntity<>(responseMap, HttpStatus.OK);
		}

	}

	public ResponseEntity postDataS(UserPostRequest userPostRequestObj) {

		if (userPostRequestObj != null && userPostRequestObj.getEmail() != null) {

			DataUser dataUserObjEmail = userRepoObj.findByEmail(userPostRequestObj.getEmail());
			if (dataUserObjEmail != null) {
				DataPosts dataPostObj = new DataPosts();
				dataPostObj.setContent(userPostRequestObj.getContent());
				dataPostObj.setCreatedDate(LocalDateTime.now());
				dataPostObj.setUser(dataUserObjEmail);

				dataRepoObj.save(dataPostObj);

				Map<String, String> responseMap = new HashMap<>();

				responseMap.put("msg", "Post Saved");

				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			} else {
				Map<String, String> responseMap = new HashMap<>();
				responseMap.put("msg", "User not found");

				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			}

		} else {
			Map<String, String> responseMap = new HashMap<>();

			responseMap.put("msg", "Something went Wrong");

			return new ResponseEntity<>(responseMap, HttpStatus.OK);
		}

	}

	public ResponseEntity likeDataS(UserLikeRequest userLikeReqObj) {

//		if (userLikeReqObj != null && userLikeReqObj.getEmail() != null) {
//
//			DataUser dataUserObjEmail = userRepoObj.findByEmail(userLikeReqObj.getEmail());
//			if (dataUserObjEmail != null) {
//				DataLikes likes = new DataLikes();
//				likes.setPost();
//				likes.setUser(dataUserObjEmail);
//			}
//		
//		}

		if (userLikeReqObj != null && userLikeReqObj.getUserId() != null && userLikeReqObj.getTweetId()!= null) {

			Optional<DataUser> dataUserObjUserId = userRepoObj.findById(userLikeReqObj.getUserId());

			Optional<DataPosts> dataPostObjTweetId = dataRepoObj.findById(userLikeReqObj.getTweetId());
			
			DataLikes likes1 = likeRepoObj.findByUserAndPost(dataUserObjUserId, dataPostObjTweetId);

			if (likes1==null && dataUserObjUserId.isPresent() && dataPostObjTweetId.isPresent()) {
				DataLikes likes = new DataLikes();
				likes.setPost(dataPostObjTweetId.get());
				likes.setUser(dataUserObjUserId.get());

				likeRepoObj.save(likes);
				Map<String, String> responseMap = new HashMap<>();
				responseMap.put("msg", "Liked Successfully");
				return new ResponseEntity<>(responseMap, HttpStatus.OK);

			} else if(likes1!=null){
				Map<String, String> responseMap = new HashMap<>();
				responseMap.put("msg", "Already liked");

				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			}else if(!dataPostObjTweetId.isPresent() && dataUserObjUserId.isPresent()) {
				Map<String, String> responseMap = new HashMap<>();
				responseMap.put("msg", "Tweet Id not found");

				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			}
			
			
			else {
				Map<String, String> responseMap = new HashMap<>();
				responseMap.put("msg", "User not found");

				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			}
		}else {
			Map<String, String> responseMap = new HashMap<>();

			responseMap.put("msg", "Something went Wrong");

			return new ResponseEntity<>(responseMap, HttpStatus.OK);
		}

	}
	
	public ResponseEntity followDataS(UserFollowerRequest userFollowReqObj) {
		
		if(userFollowReqObj!=null && userFollowReqObj.getFollower()!=null && userFollowReqObj.getFollowing()!=null) {
			Optional<DataUser> followerObj = userRepoObj.findById(userFollowReqObj.getFollower());
			Optional<DataUser> followingObj = userRepoObj.findById(userFollowReqObj.getFollowing());
			
			DataFollowers dataFollowObj = followerRepoObj.findByFollowerAndFollowing(followerObj,followingObj);
			
			if(dataFollowObj==null && followerObj.isPresent() && followingObj.isPresent()) {
				DataFollowers dataFollowSaveObj = new DataFollowers();
				dataFollowSaveObj.setFollower(followerObj.get());
				dataFollowSaveObj.setFollowing(followingObj.get());
				followerRepoObj.save(dataFollowSaveObj);
				Map<String, String> responseMap = new HashMap<>();
				responseMap.put("msg", "Followed Successfully");
				return new ResponseEntity<>(responseMap, HttpStatus.OK);
				
			}else if(userFollowReqObj.getFollower()==userFollowReqObj.getFollowing()) {
				Map<String, String> responseMap = new HashMap<>();
				responseMap.put("msg", "Can't Follow yourself");
				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			}
			else if(dataFollowObj!=null) {
				Map<String, String> responseMap = new HashMap<>();
				responseMap.put("msg", "Already Following");
				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			}else {
				Map<String, String> responseMap = new HashMap<>();
				responseMap.put("msg", "User not found");
				return new ResponseEntity<>(responseMap, HttpStatus.OK);
			}
			
		}else {
			Map<String, String> responseMap = new HashMap<>();

			responseMap.put("msg", "Something went Wrong");

			return new ResponseEntity<>(responseMap, HttpStatus.OK);
		}
		
	}
	
	public ResponseEntity FetchFollowingPostS(FetchFollowingPostRequest fetchFollowingReq) {
		
		if(fetchFollowingReq!=null) {
			//using query
//			DataUser dataUserFetchObj = userRepoObj.findByEmail(fetchFollowingReq.getEmail());
//			List<DataPostResponse> posts = followerRepoObj.fetchFollowerFeed(dataUserFetchObj.getUserId());
//			return new ResponseEntity(posts, HttpStatus.OK)	;
			
			//return new ResponseEntity(followerRepoObj.fetchFollowerFeed(userRepoObj.findByEmail(fetchFollowingReq.getEmail()).getUserId()), HttpStatus.OK);	
			
			
			//using jpa
			DataUser dataUserFetchObj = userRepoObj.findByEmail(fetchFollowingReq.getEmail());
			List<DataFollowers> followingId = followerRepoObj.findByFollower(dataUserFetchObj);
			

			
			List<FetchFollowingPostResponse> posts = new ArrayList<>();
			
			for(DataFollowers followings : followingId ) {
				Optional<DataUser> followUser = userRepoObj.findById(followings.getFollowing().getUserId());
				if(followUser.isPresent()) {
					for(DataPosts pos : followUser.get().getPosts()) {
//						System.out.println(pos.getLikes().size());
//						for(DataLikes like : pos.getLikes()) {
//							System.out.println(like);
//						}
						posts.add(new FetchFollowingPostResponse(pos.getContent(),pos.getCreatedDate(),pos.getLikes().size()));
					}
				}
				
				
			}
			
			
			return new ResponseEntity(posts, HttpStatus.OK)	;
			
			
			
		}else {
			Map<String, String> responseMap = new HashMap<>();

			responseMap.put("msg", "Something went Wrong");

			return new ResponseEntity<>(responseMap, HttpStatus.OK);
		}
		
	}
	


}
