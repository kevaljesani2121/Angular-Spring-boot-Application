package com.example.demo.model;

import javax.validation.constraints.NotBlank;

//@Entity


public class LoginRequestModel {
//
	@NotBlank
	private String email;
	@NotBlank
	private String password;

	@Override
	public String toString() {
		return "LoginRequestModel [email=" + email + ", password=" + password + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
