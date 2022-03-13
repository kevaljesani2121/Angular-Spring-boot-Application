package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.UserRecord;

@Repository

public interface UserRepository extends JpaRepository<UserRecord, Long>{

	void deleteCustomerById(Long id);

	UserRecord findCustomerById(Long id);

	UserRecord findCustomerByEmail(String email);
	
//	@Query("select u from user_record u where u.email =: email")
//  public UserRecord findCustomerForLogin(@Param ("email") String email);
}
