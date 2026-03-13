package com.microblog.db_service.Service;


import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.microblog.db_service.DataModel.DataUser;
import com.microblog.db_service.Model.RequestEntity.UserDeleteRequest;
import com.microblog.db_service.Model.RequestEntity.UserRequest;
import com.microblog.db_service.Model.RequestEntity.UserUpdatedRequest;
import com.microblog.db_service.Model.ResponseEntity.InsertUpdateDeleteResponse;
import com.microblog.db_service.Repository.IDataUserRepo;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserDBSvcTest {
	
	@Mock
	IDataUserRepo userRepoObj;
	
	@InjectMocks
	UserDBSvc userDbSvcObj;
	
	@Test
	void UserAlreadyExistTest() {
		//mocked request getting from user
		UserRequest reqObj = new UserRequest();
		reqObj.setEmail("test@gmail.com");
		
		//mocked database
		DataUser dbobj = new DataUser();
		Mockito.when(userRepoObj.findByEmail("test@gmail.com")).thenReturn(dbobj);
		
		ResponseEntity<InsertUpdateDeleteResponse> response = userDbSvcObj.insertUserDataS(reqObj);
		
		Assertions.assertEquals("User Already Exist", response.getBody().getMsg());
	}
	
	@Test
	void UserNameNotAvailable() {
		UserRequest req = new UserRequest();
		req.setEmail("test@gmail.com");
		req.setUsername("testName");
		
		DataUser dobj = new DataUser();
		Mockito.when(userRepoObj.findByEmail("test@gmail.com")).thenReturn(null);
		Mockito.when(userRepoObj.findByUsername("testName")).thenReturn(dobj);
		
		ResponseEntity<InsertUpdateDeleteResponse> response = userDbSvcObj.insertUserDataS(req);
		
		Assertions.assertEquals("UserName Not Available", response.getBody().getMsg());
	}
	
	@Test
	void UserCreated() {
		UserRequest req = new UserRequest();
		req.setEmail("test@gmail.com");
		req.setUsername("testName");
		req.setName("Sayali");
		req.setPassword("1234");
		
		DataUser dobj = new DataUser();
		Mockito.when(userRepoObj.findByEmail("test@gmail.com")).thenReturn(null);
		Mockito.when(userRepoObj.findByUsername("testName")).thenReturn(null);
		
		ResponseEntity<InsertUpdateDeleteResponse> response = userDbSvcObj.insertUserDataS(req);
		
		Assertions.assertEquals("User Created", response.getBody().getMsg());		
		//check whether dataInserted in db
//		Mockito.verify(userRepoObj).save(dobj);
		Mockito.verify(userRepoObj,times(1)).save(Mockito.any(DataUser.class));
	}
	
	
	@Test
	void UserUpdated() {
		UserUpdatedRequest req = new UserUpdatedRequest();
		req.setEmail("test@gmail.com");
		req.setName("Sayali");
		req.setUsername("testName");
		req.setPassword("1234");
		
		DataUser dobj = new DataUser();
		Mockito.when(userRepoObj.findByEmail("test@gmail.com")).thenReturn(dobj);
		
		ResponseEntity<InsertUpdateDeleteResponse> response = userDbSvcObj.updateUserDataS(req);
		
		Assertions.assertEquals("User Updated", response.getBody().getMsg());
		
		Mockito.verify(userRepoObj).save(Mockito.any(DataUser.class));
		
	}
	
	@Test
	void UserNotFound() {
		UserUpdatedRequest req = new UserUpdatedRequest();
		req.setEmail("test@gmail.com");
		req.setName("Sayali");
		req.setUsername("testName");
		req.setPassword("1234");
		
		DataUser dobj = new DataUser();
		Mockito.when(userRepoObj.findByEmail("test@gmail.com")).thenReturn(null);
		
		ResponseEntity<InsertUpdateDeleteResponse> response = userDbSvcObj.updateUserDataS(req);
		Assertions.assertEquals("User not found", response.getBody().getMsg());
	}
	
	@Test
	void UserDeleted() {
		UserDeleteRequest req= new UserDeleteRequest();
		req.setEmail("test@gmail.com");
		
		DataUser dobj = new DataUser();
		Mockito.when(userRepoObj.findByEmail("test@gmail.com")).thenReturn(dobj);
		
		ResponseEntity<InsertUpdateDeleteResponse> res = userDbSvcObj.deleteUserDataS(req);
		Assertions.assertEquals("User deleted", res.getBody().getMsg());
		
		Mockito.verify(userRepoObj).delete(dobj);
	}

}
