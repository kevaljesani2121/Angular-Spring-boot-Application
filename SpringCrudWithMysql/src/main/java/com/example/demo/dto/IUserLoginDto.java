package com.example.demo.dto;

import java.util.List;
import java.util.Map;

import com.example.demo.model.UserRecord;

public interface IUserLoginDto {
	
	public abstract UserRecord addCustomer(UserRecord customer);
	
	public abstract List<UserRecord> findAllCustomer();
	
	public abstract UserRecord updateCustomer(UserRecord updateCustomer);
	
	public abstract UserRecord findCustomerById(Long id);
	
	public abstract void deleteCustomer(Long id);
	
	public abstract Map<String,Object> findCustomerByEmail(String email,String password);
	
}
