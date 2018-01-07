package com.sample.appserver.application;

/**
 * Created by satoshi on 2017/11/07.
 */
public class UserCredential {
	private String userId;
	private String password;

	public UserCredential(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}
}
