package com.example.demo.controllar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import com.example.demo.dto.IUserLoginDto;
import com.example.demo.model.UserRecord;

@RestController

@RequestMapping("/student")

public class CustomerResource {

	@Autowired
	IUserLoginDto userService;

	@GetMapping("/getall")
	public ResponseEntity<List<UserRecord>> getAllCustomer() {
		
		List<UserRecord> customerList = userService.findAllCustomer();
		return new ResponseEntity<>(customerList, HttpStatus.OK);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserRecord> getCustomerById(@PathVariable("id") Long id) {
	
		UserRecord customerList = userService.findCustomerById(id);
		return new ResponseEntity<>(customerList, HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<UserRecord> addCustomer(@RequestBody UserRecord customer) {
	
		UserRecord customeRecord = userService.addCustomer(customer);
		return new ResponseEntity<>(customeRecord, HttpStatus.CREATED);
	
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserRecord> updateCustomer(@PathVariable("id") Long id, @RequestBody UserRecord customer) {

		customer.setId(id);
		UserRecord customerUpdate = userService.updateCustomer(customer);
		return new ResponseEntity<>(customerUpdate, HttpStatus.OK);

	}

	@PostMapping("/login")
	public Map<String, Object> loginUser(@RequestBody UserRecord userRecord) {

		return userService.findCustomerByEmail(userRecord.getEmail(), userRecord.getPassword());
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<UserRecord> deleteCustomer(@PathVariable("id") Long id) {
		userService.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
