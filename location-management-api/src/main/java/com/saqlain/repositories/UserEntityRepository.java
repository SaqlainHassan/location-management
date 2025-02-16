package com.saqlain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saqlain.entitites.UserEntity;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {
	
	public UserEntity findByEmailAndPassword(String email, String password);
	public UserEntity findByEmail(String email);

}
