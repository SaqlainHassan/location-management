package com.saqlain.entitites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "USER_TABLE")
@Data
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id; 
	@Column(name = "FULL_NAME")
	private String fullName;
	private String mobileNumber;
	private String email;
	private String password;

}
