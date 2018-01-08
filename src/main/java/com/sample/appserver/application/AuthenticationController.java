package com.sample.appserver.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by satoshi on 2017/11/07.
 */
@RestController
public class AuthenticationController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

  @PostMapping(path = "/authentication", consumes = "application/json")
  public AccessToken authentication(@Validated @RequestBody UserCredential credential) {
    AccessToken at = new AccessToken("abcdefg" + credential.userId, 3600L);
    return at;
  }
}
