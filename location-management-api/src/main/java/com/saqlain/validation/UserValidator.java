package com.saqlain.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.saqlain.constants.ErrorType;
import com.saqlain.exceptions.ErrorModel;
import com.saqlain.models.UserModel;

@Component
public class UserValidator {
	
	public List<ErrorModel> validateRequest(UserModel userModel){
		
		List<ErrorModel> errorModelList = new ArrayList<>();
		
		if(null != userModel && userModel.getEmail() == null) {
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode(ErrorType.NOT_EMPTY.toString());
			errorModel.setMessage("Email cannot be empty");
			errorModelList.add(errorModel);
		}
		
		if(null != userModel && userModel.getPassword() == null) {
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode(ErrorType.NOT_EMPTY.toString());
			errorModel.setMessage("Password cannot be empty");
			errorModelList.add(errorModel);
		}
		
		return errorModelList;
	}

}
