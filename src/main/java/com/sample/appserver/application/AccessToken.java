package com.sample.appserver.application;

/**
 * Created by satoshi on 2017/11/07.
 */
public class AccessToken {
	private String accessToken;
	private Long expiresIn;

	public AccessToken(String accessToken, Long expiresIn) {
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}
}
