package com.kgate.bean;

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

//@Entity
//@Table(name = "MainGameDataBean")
public class MainGameDataBean {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long phoneNumber;
	private String feedback;
	private String duration;
	private String dateTime;
	private String percentage;
//	@OneToMany
//	(targetEntity = QuestionDataBean.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "maingamedata_questiondata", joinColumns = { @JoinColumn(name = "phoneNumber") }, inverseJoinColumns = {
//			@JoinColumn(name = "objective") })
//	private List<QuestionDataBean> questionData = new ArrayList<>();
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
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
//	public List<QuestionDataBean> getQuestionData() {
//		return questionData;
//	}
//	public void setQuestionData(List<QuestionDataBean> questionData) {
//		this.questionData = questionData;
//	}
	@Override
	public String toString() {
		return "MainGameDataBean [phoneNumber=" + phoneNumber + ", feedback=" + feedback + ", duration=" + duration
				+ ", dateTime=" + dateTime + ", percentage=" + percentage + ", questionData=]";
	}
}
