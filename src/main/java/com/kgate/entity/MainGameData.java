package com.kgate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Entity
//@Table(name = "MainGameData")
public class MainGameData {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String phoneNumber;
	private String feedback;
	private String duration;
	private String dateTime;
	private String percentage;
//	@OneToMany(targetEntity = QuestionData.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "MainGameData_QuestionData", joinColumns = { @JoinColumn(name = "phoneNumber") }, inverseJoinColumns = {
//			@JoinColumn(name = "objective") })
//	private List<QuestionData> questionData = new ArrayList<>();
//	public List<QuestionData> getQuestionData() {
//		return questionData;
//	}
//
//	public void setQuestionData(List<QuestionData> questionData) {
//		this.questionData = questionData;
//	}

	 @JsonProperty("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phoneNumber")
	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

	@JsonProperty("feedback")
	public String getFeedback() {
		return feedback;
	}

	@JsonProperty("feedback")
	public void setFeedback(String value) {
		this.feedback = value;
	}

	@JsonProperty("Duration")
	public String getDuration() {
		return duration;
	}

	@JsonProperty("Duration")
	public void setDuration(String value) {
		this.duration = value;
	}

	@JsonProperty("DateTime")
	public String getDateTime() {
		return dateTime;
	}

	@JsonProperty("DateTime")
	public void setDateTime(String value) {
		this.dateTime = value;
	}

	@JsonProperty("Percentage")
	public String getPercentage() {
		return percentage;
	}

	@JsonProperty("Percentage")
	public void setPercentage(String value) {
		this.percentage = value;
	}

	@Override
	public String toString() {
		return "MainGameData [phoneNumber=" + phoneNumber + ", feedback=" + feedback + ", duration=" + duration
				+ ", dateTime=" + dateTime + ", percentage=" + percentage + "]";
	}

}
