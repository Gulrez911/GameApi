package com.kgate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kgate.entity.User;
import com.kgate.entity.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

	@Query("select u from UserLogin u where u.username=:username and u.password=:password")
	public UserLogin authenticate(@Param("username") String username, @Param("password") String password);

	@Query(value = "from UserLogin u where u.username=:email ")
	UserLogin findPassword(@Param("email") String email);

	@Modifying
	@Query("update UserLogin u set u.password=:password where u.username=:username")
	void updateUser(@Param("username") String username, @Param("password") String password);
}
