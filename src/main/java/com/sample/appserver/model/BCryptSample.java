package com.sample.appserver.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by satoshi on 2017/12/27.
 */
@Component
public class BCryptSample {

  private static final Logger LOGGER = LoggerFactory.getLogger(BCryptSample.class);

  @Autowired
  PasswordEncoder passwordEncoder;

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  public String encodeByBCrypt(String msg) {
    String digest = passwordEncoder.encode(msg);
    LOGGER.info("bcrypt. from:{} to:{}", msg, digest);
    return digest;
  }

  public boolean isMatch(String msg) {
    // read data from mysql db
    // check the hashed password
    return false;
  }

}
