package com.kgate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kgate.entity.User;
import com.kgate.entity.UserLogin;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT mobile,email,firstName,lastName FROM User where mobile=?1")
	List<User> findBymobile(String  string);
	
	@Query("from User")
	public List<User> getUser();
	
	@Query(value = "from User u where u.mobile=:mobile ")
	User checkmobile(@Param("mobile") Long mobile);
}
