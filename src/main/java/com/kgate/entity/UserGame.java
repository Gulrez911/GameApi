package com.kgate.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "UserGame")
public class UserGame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long gameId;
	
	String mobile;
	
	private String gameName;
//	@DateTimeFormat(pattern="dd-mm-yy")
	@Temporal(TemporalType.DATE)
	private Date played = new Date();
	private Long starPoints;

	private String q1;
	private String q2;
	private String q3;
	private String q4;

	private String q5;
	private String q6;
	private String q7;
	private String q8;

	private String qa1;
	private String qa2;
	private String qa3;
	private String qa4;

	private String qa5;
	private String qa6;
	private String qa7;
	private String qa8;

	private String statusA1;
	private String statusA2;
	private String statusA3;
	private String statusA4;
	private String statusA5;
	private String statusA6;
	private String statusA7;
	private String statusA8;

	private Double score;

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Date getPlayed() {
		return played;
	}

	public void setPlayed(Date played) {
		this.played = played;
	}

	public Long getStarPoints() {
		return starPoints;
	}

	public void setStarPoints(Long starPoints) {
		this.starPoints = starPoints;
	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	public String getQ4() {
		return q4;
	}

	public void setQ4(String q4) {
		this.q4 = q4;
	}

	public String getQ5() {
		return q5;
	}

	public void setQ5(String q5) {
		this.q5 = q5;
	}

	public String getQ6() {
		return q6;
	}

	public void setQ6(String q6) {
		this.q6 = q6;
	}

	public String getQ7() {
		return q7;
	}

	public void setQ7(String q7) {
		this.q7 = q7;
	}

	public String getQ8() {
		return q8;
	}

	public void setQ8(String q8) {
		this.q8 = q8;
	}

	public String getQa1() {
		return qa1;
	}

	public void setQa1(String qa1) {
		this.qa1 = qa1;
	}

	public String getQa2() {
		return qa2;
	}

	public void setQa2(String qa2) {
		this.qa2 = qa2;
	}

	public String getQa3() {
		return qa3;
	}

	public void setQa3(String qa3) {
		this.qa3 = qa3;
	}

	public String getQa4() {
		return qa4;
	}

	public void setQa4(String qa4) {
		this.qa4 = qa4;
	}

	public String getQa5() {
		return qa5;
	}

	public void setQa5(String qa5) {
		this.qa5 = qa5;
	}

	public String getQa6() {
		return qa6;
	}

	public void setQa6(String qa6) {
		this.qa6 = qa6;
	}

	public String getQa7() {
		return qa7;
	}

	public void setQa7(String qa7) {
		this.qa7 = qa7;
	}

	public String getQa8() {
		return qa8;
	}

	public void setQa8(String qa8) {
		this.qa8 = qa8;
	}

	public String getStatusA1() {
		return statusA1;
	}

	public void setStatusA1(String statusA1) {
		this.statusA1 = statusA1;
	}

	public String getStatusA2() {
		return statusA2;
	}

	public void setStatusA2(String statusA2) {
		this.statusA2 = statusA2;
	}

	public String getStatusA3() {
		return statusA3;
	}

	public void setStatusA3(String statusA3) {
		this.statusA3 = statusA3;
	}

	public String getStatusA4() {
		return statusA4;
	}

	public void setStatusA4(String statusA4) {
		this.statusA4 = statusA4;
	}

	public String getStatusA5() {
		return statusA5;
	}

	public void setStatusA5(String statusA5) {
		this.statusA5 = statusA5;
	}

	public String getStatusA6() {
		return statusA6;
	}

	public void setStatusA6(String statusA6) {
		this.statusA6 = statusA6;
	}

	public String getStatusA7() {
		return statusA7;
	}

	public void setStatusA7(String statusA7) {
		this.statusA7 = statusA7;
	}

	public String getStatusA8() {
		return statusA8;
	}

	public void setStatusA8(String statusA8) {
		this.statusA8 = statusA8;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "UserGame [gameId=" + gameId + ", gameName=" + gameName + ", played=" + played
				+ ", starPoints=" + starPoints + ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3
				+ ", q4=" + q4 + ", q5=" + q5 + ", q6=" + q6 + ", q7=" + q7 + ", q8=" + q8
				+ ", qa1=" + qa1 + ", qa2=" + qa2 + ", qa3=" + qa3 + ", qa4=" + qa4 + ", qa5="
				+ qa5 + ", qa6=" + qa6 + ", qa7=" + qa7 + ", qa8=" + qa8 + ", statusA1="
				+ statusA1 + ", statusA2=" + statusA2 + ", statusA3=" + statusA3 + ", statusA4="
				+ statusA4 + ", statusA5=" + statusA5 + ", statusA6=" + statusA6 + ", statusA7="
				+ statusA7 + ", statusA8=" + statusA8 + ", score=" + score + "]";
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

}
