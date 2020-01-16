package com.kgate.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter(value = "beanFilter")
public class LeaderBoard {

	public long mobile;
	public String rank;
	public String starPoints;

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getStarPoints() {
		return starPoints;
	}

	public void setStarPoints(String starPoints) {
		this.starPoints = starPoints;
	}

	@Override
	public String toString() {
		return "LeaderBoard [mobile=" + mobile + ", rank=" + rank + ", starPoints=" + starPoints + "]";
	}
}
