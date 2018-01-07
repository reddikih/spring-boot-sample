package com.sample.appserver.config;

import org.springframework.boot.web.server.*;
import org.springframework.boot.web.servlet.server.*;
import org.springframework.stereotype.*;

/**
 * Created by satoshi on 2017/11/07.
 */
@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
	private static final int APP_SERVER_PORT = 8809;
	@Override
	public void customize(ConfigurableServletWebServerFactory server) {
		server.setPort(APP_SERVER_PORT);
	}
}
