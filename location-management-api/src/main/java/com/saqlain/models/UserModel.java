package com.saqlain.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserModel {
	private String fullName;
	private String mobileNumber;
	private String email;
	private String password;

}
