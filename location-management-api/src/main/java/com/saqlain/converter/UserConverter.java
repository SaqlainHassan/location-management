package com.saqlain.converter;

import org.springframework.stereotype.Component;

import com.saqlain.entitites.UserEntity;
import com.saqlain.models.UserModel;

@Component
public class UserConverter {
	
	public UserEntity convertModelToEntity(UserModel userModel) {
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setEmail(userModel.getEmail());
		userEntity.setFullName(userModel.getFullName());
		userEntity.setMobileNumber(userModel.getMobileNumber());
		userEntity.setPassword(userModel.getPassword());
		
		return userEntity;
	}

}
