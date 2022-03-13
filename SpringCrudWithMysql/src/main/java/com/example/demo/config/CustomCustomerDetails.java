package com.example.demo.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.UserRecord;

public class CustomCustomerDetails implements UserDetails{

	private UserRecord customeRecord;
	
	
	
	public CustomCustomerDetails(UserRecord customeRecord) {
		super();
		this.customeRecord=customeRecord;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(customeRecord.getRole());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		return customeRecord.getPassword();
	}

	@Override
	public String getUsername() {
		return customeRecord.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
