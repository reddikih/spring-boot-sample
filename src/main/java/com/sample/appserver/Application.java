package com.sample.appserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by satoshi on 2017/11/07.
 */
@SpringBootApplication
public class Application {

//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }
}
