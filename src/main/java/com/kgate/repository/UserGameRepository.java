package com.kgate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
