package com.saqlain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saqlain.exceptions.BusinessException;
import com.saqlain.models.UserModel;
import com.saqlain.repositories.UserEntityRepository;
import com.saqlain.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<Boolean> login(@RequestBody UserModel userModel) throws BusinessException {
		
		boolean result = userService.login(userModel);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
		
		return responseEntity;
	}
	@PostMapping("/users/add")
	public ResponseEntity<Long> register(@RequestBody UserModel userModel) throws BusinessException {
		
		Long result = userService.register(userModel);
		ResponseEntity<Long> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);
		
		return responseEntity;
	}
}
