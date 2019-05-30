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

	private String feedback;
	private String duration;
	private String dateTime;
	private String percentage;
	private String objective;

	private String restult1;
	private String restult2;
	private String restult3;
	private String restult4;
	private String restult5;
	private String restult6;
	private String restult7;
	private String restult8;

	private String type1;
	private String type2;
	private String type3;
	private String type4;
	private String type5;
	private String type6;
	private String type7;
	private String type8;

	private int qNo1;
	private int qNo2;
	private int qNo3;
	private int qNo4;
	private int qNo5;
	private int qNo6;
	private int qNo7;
	private int qNo8;

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

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getRestult1() {
		return restult1;
	}

	public void setRestult1(String restult1) {
		this.restult1 = restult1;
	}

	public String getRestult2() {
		return restult2;
	}

	public void setRestult2(String restult2) {
		this.restult2 = restult2;
	}

	public String getRestult3() {
		return restult3;
	}

	public void setRestult3(String restult3) {
		this.restult3 = restult3;
	}

	public String getRestult4() {
		return restult4;
	}

	public void setRestult4(String restult4) {
		this.restult4 = restult4;
	}

	public String getRestult5() {
		return restult5;
	}

	public void setRestult5(String restult5) {
		this.restult5 = restult5;
	}

	public String getRestult6() {
		return restult6;
	}

	public void setRestult6(String restult6) {
		this.restult6 = restult6;
	}

	public String getRestult7() {
		return restult7;
	}

	public void setRestult7(String restult7) {
		this.restult7 = restult7;
	}

	public String getRestult8() {
		return restult8;
	}

	public void setRestult8(String restult8) {
		this.restult8 = restult8;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getType3() {
		return type3;
	}

	public void setType3(String type3) {
		this.type3 = type3;
	}

	public String getType4() {
		return type4;
	}

	public void setType4(String type4) {
		this.type4 = type4;
	}

	public String getType5() {
		return type5;
	}

	public void setType5(String type5) {
		this.type5 = type5;
	}

	public String getType6() {
		return type6;
	}

	public void setType6(String type6) {
		this.type6 = type6;
	}

	public String getType7() {
		return type7;
	}

	public void setType7(String type7) {
		this.type7 = type7;
	}

	public String getType8() {
		return type8;
	}

	public void setType8(String type8) {
		this.type8 = type8;
	}

	public int getqNo1() {
		return qNo1;
	}

	public void setqNo1(int qNo1) {
		this.qNo1 = qNo1;
	}

	public int getqNo2() {
		return qNo2;
	}

	public void setqNo2(int qNo2) {
		this.qNo2 = qNo2;
	}

	public int getqNo3() {
		return qNo3;
	}

	public void setqNo3(int qNo3) {
		this.qNo3 = qNo3;
	}

	public int getqNo4() {
		return qNo4;
	}

	public void setqNo4(int qNo4) {
		this.qNo4 = qNo4;
	}

	public int getqNo5() {
		return qNo5;
	}

	public void setqNo5(int qNo5) {
		this.qNo5 = qNo5;
	}

	public int getqNo6() {
		return qNo6;
	}

	public void setqNo6(int qNo6) {
		this.qNo6 = qNo6;
	}

	public int getqNo7() {
		return qNo7;
	}

	public void setqNo7(int qNo7) {
		this.qNo7 = qNo7;
	}

	public int getqNo8() {
		return qNo8;
	}

	public void setqNo8(int qNo8) {
		this.qNo8 = qNo8;
	}

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserGame [gameId=" + gameId + ", feedback=" + feedback + ", duration=" + duration
				+ ", dateTime=" + dateTime + ", percentage=" + percentage + ", objective="
				+ objective + ", restult1=" + restult1 + ", restult2=" + restult2
				+ ", restult3=" + restult3 + ", restult4=" + restult4 + ", restult5=" + restult5
				+ ", restult6=" + restult6 + ", restult7=" + restult7 + ", restult8=" + restult8
				+ ", type1=" + type1 + ", type2=" + type2 + ", type3=" + type3 + ", type4="
				+ type4 + ", type5=" + type5 + ", type6=" + type6 + ", type7=" + type7
				+ ", type8=" + type8 + ", qNo1=" + qNo1 + ", qNo2=" + qNo2 + ", qNo3=" + qNo3
				+ ", qNo4=" + qNo4 + ", qNo5=" + qNo5 + ", qNo6=" + qNo6 + ", qNo7=" + qNo7
				+ ", qNo8=" + qNo8 + ", mobile=" + mobile + ", gameName=" + gameName
				+ ", played=" + played + ", starPoints=" + starPoints + ", q1=" + q1 + ", q2="
				+ q2 + ", q3=" + q3 + ", q4=" + q4 + ", q5=" + q5 + ", q6=" + q6 + ", q7=" + q7
				+ ", q8=" + q8 + ", qa1=" + qa1 + ", qa2=" + qa2 + ", qa3=" + qa3 + ", qa4="
				+ qa4 + ", qa5=" + qa5 + ", qa6=" + qa6 + ", qa7=" + qa7 + ", qa8=" + qa8
				+ ", statusA1=" + statusA1 + ", statusA2=" + statusA2 + ", statusA3=" + statusA3
				+ ", statusA4=" + statusA4 + ", statusA5=" + statusA5 + ", statusA6=" + statusA6
				+ ", statusA7=" + statusA7 + ", statusA8=" + statusA8 + ", score=" + score
				+ "]";
	}

}
