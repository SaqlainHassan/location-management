package com.saqlain.exceptions;

import java.util.List;

import lombok.Data;

@Data
public class BusinessException extends Exception {
	
	private List<ErrorModel> errorList;

	public BusinessException(List<ErrorModel> errorList) {
		 this.errorList = errorList;
	}

	
	
	

}
