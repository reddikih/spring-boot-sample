package com.sample.appserver.application;

import org.springframework.web.bind.annotation.*;

/**
 * Created by satoshi on 2017/11/07.
 */
@RestController
public class AuthenticationController {

	@PostMapping(path = "/authentication", consumes = "application/json")
	public AccessToken authentication(@RequestBody UserCredential credential) {
		AccessToken at = new AccessToken("abcdefg", 3600L);
		return at;
	}
}
