package com.kgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgate.entity.UserGame;
@Repository
public interface UserGameRepository extends JpaRepository<UserGame, Long>{

}
