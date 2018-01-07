package com.sample.appserver;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by satoshi on 2017/11/07.
 */
@SpringBootApplication
public class Application {

//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	public static void main(String ... args) {
		SpringApplication.run(Application.class, args);
	}
}
