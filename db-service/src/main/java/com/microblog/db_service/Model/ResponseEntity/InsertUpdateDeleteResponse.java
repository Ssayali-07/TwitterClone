package com.microblog.db_service.Model.ResponseEntity;

import lombok.Data;

@Data
public class InsertUpdateDeleteResponse { 
	
	public String msg;

	public InsertUpdateDeleteResponse(String msg) {
		super();
		this.msg = msg;
	}
	

}
