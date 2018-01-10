package com.sample.appserver.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by satoshi on 2017/11/07.
 */
@Component
public class CustomizationBean implements
    WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

  private static final int APP_SERVER_PORT = 8809;

  @Override
  public void customize(ConfigurableServletWebServerFactory server) {
    server.setPort(APP_SERVER_PORT);
  }
}
