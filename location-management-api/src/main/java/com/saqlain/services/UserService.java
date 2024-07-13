package com.saqlain.services;

import com.saqlain.exceptions.BusinessException;
import com.saqlain.models.UserModel;

public interface UserService {
	
	public boolean login(UserModel userModel) throws BusinessException;
	public Long register(UserModel userModel) throws BusinessException;
}
