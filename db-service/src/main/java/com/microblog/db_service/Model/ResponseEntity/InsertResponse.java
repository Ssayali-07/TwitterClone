package com.microblog.db_service.Model.ResponseEntity;

import lombok.Data;

@Data
public class InsertResponse {
	
	public String msg;

	public InsertResponse(String msg) {
		super();
		this.msg = msg;
	}
	

}
