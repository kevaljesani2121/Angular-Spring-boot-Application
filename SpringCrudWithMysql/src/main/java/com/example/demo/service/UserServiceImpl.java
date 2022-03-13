package com.example.demo.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.custome.exception.BusinessException;
import com.example.demo.dto.IUserLoginDto;
import com.example.demo.model.UserRecord;
import com.example.demo.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@CrossOrigin
public class UserServiceImpl implements IUserLoginDto {

	@Autowired
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserRecord addCustomer(UserRecord customer) {
		try {
			if (customer.getEmail().isEmpty() || customer.getEmail().length() == 0) {
				throw new BusinessException("Please send proper emaill ,It is blank", "601");
			}
			customer.setCusomerCode(UUID.randomUUID().toString());
			return userRepository.save(customer);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("given customer is null" + e.getMessage(), "602");
		} catch (Exception e) {
			throw new BusinessException(
					"Something went wrong in Service layer while saving the customer" + e.getMessage(), "603");
		}
	}

	@Override
	public List<UserRecord> findAllCustomer() {

		try {
			List<UserRecord> list = userRepository.findAll();
			if (list.isEmpty()) {
				throw new BusinessException("Hey list completely empty ,we have nothing to return", "604");
			}
			return list;
		} catch (Exception e) {
			throw new BusinessException("605",
					"Something went wrong in Service layer while fetching all customer" + e.getMessage());
		}
	}

	@Override
	public UserRecord updateCustomer(UserRecord updateCustomer) {
		try {
			return userRepository.save(updateCustomer);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("given customer is null while update the customer" + e.getMessage(), "606");
		} catch (Exception e) {
			throw new BusinessException("607",
					"Something went wrong in Service layer  while saving the customer" + e.getMessage());

		}
	}

	@Override
	public UserRecord findCustomerById(Long id) {
		try {
			return userRepository.findCustomerById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("608",
					"given customer id is null, please send some id to be searched" + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("609", "given customer id doesnot exist in DB" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("610",
					"Something went wrong in Service layer while fetching customer" + e.getMessage());
		}
	}

	@Override
	@Transactional
	public void deleteCustomer(Long id) {
		try {
			userRepository.deleteCustomerById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("611",
					"given employee id is null, please send some id to be deleted" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("612",
					"Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
	}

	@Override
	public Map<String, Object> findCustomerByEmail(String email, String password) {
		HashMap<String, Object> objectNode = new HashMap<>();

		try {
			if ((email.isEmpty() || email.length() == 0) || (password.isEmpty() || password.length() == 0)) {
				throw new BusinessException("Please send proper emaill and password,It is blank", "613");
			}
			List<UserRecord> list = userRepository.findAll();
			for (int i = 0; i < list.size(); i++) {
				UserRecord loginUserRecord = list.get(i);
				String uemail = loginUserRecord.getEmail();
				String upassword = loginUserRecord.getPassword();
				if (email.equals(uemail) && password.equals(upassword)) {

					objectNode.put("message", "user login succefully !");
					objectNode.put("status", HttpStatus.OK);
				}
			}
			return objectNode;

		} catch (Exception e) {
			objectNode.put("message", "please to check email and password !");
			objectNode.put("status", HttpStatus.NOT_FOUND);
			return objectNode;
		}
	}

}
