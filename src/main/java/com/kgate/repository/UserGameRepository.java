package com.kgate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kgate.bean.LeaderBoard;
import com.kgate.entity.User;
import com.kgate.entity.UserGame;

@Repository
@Transactional
public interface UserGameRepository extends JpaRepository<UserGame, Long> {

	@Query("from UserGame")
	public List<UserGame> getUserGame();

	@Query(value = "SELECT * FROM gamedb.UserGame  u  order by u.mobile,u.attemptcount asc;", nativeQuery = true)
	public List<UserGame> getUserGame2();

	@Query("from UserGame u where u.gameId=:gameId")
	public UserGame getUserInfo(@Param("gameId") Long gameId);

	@Query("from UserGame u where u.attemptcount=:attemptcount and u.mobile=:mobile")
	public UserGame getByAtmptNo(@Param("attemptcount") int attemptcount, @Param("mobile") String mobile);

//	list of usergame by mobile
	@Query("from UserGame u where u.mobile=:mobile order by attemptcount asc")
	public List<UserGame> mobUsergame(@Param("mobile") String mobile);

//	
	@Modifying
	@Query("update UserGame u set u.feedback2=:feedback2, u.feedback=:feedback where u.attemptcount=:attemptcount and u.mobile=:mobile")
	public void updateUserGame(@Param("mobile") String mobile, @Param("attemptcount") int attemptcount,
			@Param("feedback2") String feedback2, @Param("feedback") String feedback);

//	@Query("FROM UserGame u  ORDER BY u.starPoints DESC Limit 0, 3")
//	@Query(value = "select u.starPoints UserGame u ORDER BY u.starPoints DESC LIMIT 3", nativeQuery = true)
//	@Query(value = "select starPoints from UserGame ORDER BY starPoints DESC LIMIT 3", nativeQuery = true)
	@Query(value = "select max(starPoints) from UserGame group by mobile ORDER BY starPoints DESC LIMIT 3", nativeQuery = true)
	public List<String> getStarPoint();

//	@Query(value = "select find_in_set(starPoints,(select group_concat(starPoints order by starPoints desc) from UserGame)) as rank from UserGame where mobile=:mobile and attemptcount=:attemptcount", nativeQuery = true)
//	@Query(value = "select mobile,max(starPoints),attemptcount,find_in_set(max(starPoints),(select group_concat(starPoints order by starPoints desc) from UserGame)) as rank from UserGame where mobile=mobile group by mobile", nativeQuery = true)
//	@Query(value = "SELECT T3.rank, TM.mobile FROM UserGame as TM INNER JOIN (SELECT mobile, FIND_IN_SET(Max(starPoints), (select GROUP_CONCAT(DISTINCT starPoints order by starPoints DESC) From (select MAX(starPoints) as starPoints FROM UserGame as T0 GROUP BY mobile) as T1)) as rank FROM UserGame as T2 where mobile=:mobile group by mobile) as T3 ON TM.mobile = T3.mobile group by mobile order by rank", nativeQuery = true)
	@Query(value = "SELECT  TM.mobile, T3.rank FROM UserGame as TM INNER JOIN (SELECT mobile, FIND_IN_SET(Max(starPoints), (select GROUP_CONCAT(DISTINCT starPoints order by starPoints DESC) From (select MAX(starPoints) as starPoints FROM UserGame as T0 GROUP BY mobile) as T1)) as rank FROM UserGame as T2 group by mobile) as T3 ON TM.mobile = T3.mobile where TM.mobile=:mobile  group by mobile order by rank;", nativeQuery = true)
	public String getRank(@Param("mobile") String mobile);

	@Query(value = "SELECT TM.gameId, max(TM.starPoints),TM.mobile, T3.rank FROM UserGame as TM INNER JOIN (SELECT mobile, FIND_IN_SET(Max(starPoints), (select GROUP_CONCAT(DISTINCT starPoints order by starPoints DESC) From (select MAX(starPoints) as starPoints FROM UserGame as T0 GROUP BY mobile) as T1)) as rank FROM UserGame as T2 group by mobile) as T3 ON TM.mobile = T3.mobile group by mobile order by rank;", nativeQuery = true)
	public List<Object> getlistRank();
	
	@Query(value = "select max(starPoints) from UserGame ug where  ug.mobile=:mobile",nativeQuery  = true)
	public String getMaxStarPoint(@Param("mobile") String mobile);
}
