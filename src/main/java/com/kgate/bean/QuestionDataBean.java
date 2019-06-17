package com.kgate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "QuestionDataBean")
public class QuestionDataBean {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer qId;
	private String objective;
	private String qNo;
	private String question;
	private String option;
	private String result;
	private String type;
	public Integer getqId() {
		return qId;
	}
	public void setqId(Integer qId) {
		this.qId = qId;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getqNo() {
		return qNo;
	}
	public void setqNo(String qNo) {
		this.qNo = qNo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "QuestionDataBean [qId=" + qId + ", objective=" + objective + ", qNo=" + qNo + ", question=" + question
				+ ", option=" + option + ", result=" + result + ", type=" + type + "]";
	}
	 
	
}
