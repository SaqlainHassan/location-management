package com.saqlain.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.saqlain.constants.ErrorType;
import com.saqlain.converter.UserConverter;
import com.saqlain.entitites.UserEntity;
import com.saqlain.exceptions.BusinessException;
import com.saqlain.exceptions.ErrorModel;
import com.saqlain.models.UserModel;
import com.saqlain.repositories.UserEntityRepository;
import com.saqlain.services.UserService;
import com.saqlain.validation.UserValidator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserEntityRepository repo;
	
	@Autowired
	private UserConverter converter;
	
	@Autowired
	private UserValidator validator;

	@Override
	public boolean login(UserModel userModel) throws BusinessException {
		

		//empty check of email and password
		List<ErrorModel> errorModelList = validator.validateRequest(userModel);
		if(!CollectionUtils.isEmpty(errorModelList)) {
			throw new BusinessException(errorModelList);
		}
		
		boolean result = false;
		UserEntity userEntity = repo.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
		if(userEntity == null) {
			List<ErrorModel> errorList = new ArrayList<>();
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode(ErrorType.AUTH_INVALID_CREDENTIALS.toString());
			errorModel.setMessage("Incorrect email and password");
			errorList.add(errorModel);
			throw new BusinessException(errorList);
		}else {
			result = true;
		}
		return result;
	}



	@Override
	public Long register(UserModel userModel) throws BusinessException {
		
		//empty check of email and password
		List<ErrorModel> errorModelList = validator.validateRequest(userModel);
		if(!CollectionUtils.isEmpty(errorModelList)) {
			throw new BusinessException(errorModelList);
		}
		
		
		//check id user existed
		UserEntity ue = repo.findByEmail(userModel.getEmail());
		if(null != ue) {
			List<ErrorModel> errorList = new ArrayList<>();
			
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode(ErrorType.ALREADY_EXIST.toString());
			errorModel.setMessage("User with this email already exist");
			errorList.add(errorModel);
			throw new BusinessException(errorList);
		}
		UserEntity userEntity = converter.convertModelToEntity(userModel);
		UserEntity userEntity1 = repo.save(userEntity);
		return userEntity1.getId(); // we want return only id because data has password also
	}

}
