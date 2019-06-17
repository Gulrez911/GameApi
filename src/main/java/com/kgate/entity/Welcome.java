package com.kgate.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Welcome {

	private MainGameData mainGameData;
	private List<QuestionData> questionData;

	@JsonProperty("MainGameData")
	public MainGameData getMainGameData() {
		return mainGameData;
	}

	@JsonProperty("MainGameData")
	public void setMainGameData(MainGameData value) {
		this.mainGameData = value;
	}

	@JsonProperty("QuestionData")
	public List<QuestionData> getQuestionData() {
		return questionData;
	}

	@JsonProperty("QuestionData")
	public void setQuestionData(List<QuestionData> value) {
		this.questionData = value;
	}

	@Override
	public String toString() {
		return "Welcome [mainGameData=" + mainGameData + ", questionData=" + questionData + "]";
	}
}
