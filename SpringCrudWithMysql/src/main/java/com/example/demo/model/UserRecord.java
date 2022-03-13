package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConstructorBinding;



@Entity
public class UserRecord implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=2,message = "user name should have at least 2 char")
	private String uName;
	
	
	
	@NotNull
	@Email
	private String email;
	@NotNull
	
	private String password;
	@NotNull
	@Size(max=10,min = 10,message = "mobile number must be 10 digit")
	private String phoneNumber;
	private String birthDate;
	private String address;
	private String city;

	@ConstructorBinding
	public UserRecord() {
  
 }
	
	public UserRecord( String uName, String email, String password, String phoneNumber, String birthDate,
			String address, String city) {
		super();
		
		this.uName = uName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.address = address;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String toString() {
		return "UserRecord [id=" + id + ", uName=" + uName + ", email=" + email + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate + ", address=" + address + ", city="
				+ city + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, uName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRecord other = (UserRecord) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(uName, other.uName);
	}
	
	public void setCusomerCode(String string) {
		  throw new UnsupportedOperationException();

 }

	



}					
