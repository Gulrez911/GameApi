package com.kgate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kgate.entity.User;
import com.kgate.entity.UserGame;

@Repository
@Transactional
public interface UserGameRepository extends JpaRepository<UserGame, Long> {

	@Query("from UserGame")
	public List<UserGame> getUserGame();

	@Query("from UserGame u where u.gameId=:gameId")
	public UserGame getUserInfo(@Param("gameId") Long gameId);

	@Query("from UserGame u where u.attemptcount=:attemptcount and u.mobile=:mobile")
	public UserGame getByAtmptNo(@Param("attemptcount") int attemptcount, @Param("mobile") String mobile);

	@Modifying
	@Query("update UserGame u set u.feedback2=:feedback2, u.feedback=:feedback where u.attemptcount=:attemptcount and u.mobile=:mobile")
	public void updateUserGame(@Param("mobile") String mobile, @Param("attemptcount") int attemptcount,
			@Param("feedback2") String feedback2, @Param("feedback") String feedback);

}
