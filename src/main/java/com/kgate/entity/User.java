package com.kgate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "User")
public class User {
	@Id
	private Long mobile;
	private String firstName;
	private String lastName;
	private String email;
	@Version
	private Long noOfAttempts;
	@OneToMany(targetEntity = UserGame.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_usergame", joinColumns = { @JoinColumn(name = "mobile") }, inverseJoinColumns = {
			@JoinColumn(name = "gameId") })
	private List<UserGame> userGame = new ArrayList<>();

	public List<UserGame> getUserGame() {
		return userGame;
	}

	public void setUserGame(List<UserGame> userGame) {
		this.userGame = userGame;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(Long noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	@Override
	public String toString() {
		return "User [mobile=" + mobile + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", noOfAttempts=" + noOfAttempts + ", userGame=" + userGame + "]";
	}

}
