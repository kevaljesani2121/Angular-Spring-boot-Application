package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.UserRecord;
import com.example.demo.repository.UserRepository;

public class CustomerDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
//		fatch data from database
		
		UserRecord userRecord=userRepository.findCustomerByEmail(username);
		
		if (userRecord==null) {
			throw new UsernameNotFoundException("could not found user !!");
		}
		
		CustomCustomerDetails customCustomerDetails=new CustomCustomerDetails(userRecord);
		
		return customCustomerDetails;
	}

}
