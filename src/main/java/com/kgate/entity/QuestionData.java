package com.kgate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Entity
//@Table(name = "QuestionData")
public class QuestionData {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer objective;
	private String qNo;
	private String question;
	private String option;
	private String result;
	private String type;

	@JsonProperty("objective")
	public Integer getObjective() {
		return objective;
	}

	@JsonProperty("objective")
	public void setObjective(Integer value) {
		this.objective = value;
	}

	@JsonProperty("qNo")
	public String getQNo() {
		return qNo;
	}

	@JsonProperty("qNo")
	public void setQNo(String value) {
		this.qNo = value;
	}

	@JsonProperty("question")
	public String getQuestion() {
		return question;
	}

	@JsonProperty("question")
	public void setQuestion(String value) {
		this.question = value;
	}

	@JsonProperty("option")
	public String getOption() {
		return option;
	}

	@JsonProperty("option")
	public void setOption(String value) {
		this.option = value;
	}

	@JsonProperty("result")
	public String getResult() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(String value) {
		this.result = value;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String value) {
		this.type = value;
	}

	@Override
	public String toString() {
		return "QuestionDatum [objective=" + objective + ", qNo=" + qNo + ", question=" + question + ", option="
				+ option + ", result=" + result + ", type=" + type + "]";
	}
}
