package com.kgate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kgate.entity.User;
import com.kgate.entity.UserGame;
import com.kgate.entity.UserLogin;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT mobile,email,firstName,lastName FROM User where mobile=?1")
	List<User> findBymobile(String string);

	@Query("from User u where u.noOfAttempts !='0' order by mobile asc")
//	@Query("from User u inner join u.userGame ug  where u.noOfAttempts !='0' order by ug.attemptcount, ug.mobile")
	//@Query("from User u  where u.noOfAttempts !='0' order by u.UserGame.attemptcount, u.UserGame.mobile")
	public List<User> getUser();

	@Query(value = "from User u where u.mobile=:mobile ")
	User checkmobile(@Param("mobile") Long mobile);

	@Query("from User u where u.mobile=:mobile")
	public User getNoAttempt(@Param("mobile") Long mobile);

	@Query("from User u where u.mobile=:mobile")
	public User getGameId(@Param("mobile") Long mobile);
}
