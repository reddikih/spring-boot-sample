package com.sample.appserver.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

  @Bean
  public ReloadableResourceBundleMessageSource messageSource() {
    ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
    ms.setBasenames("classpath:messages");
    ms.setCacheSeconds(0);
    ms.setDefaultEncoding("UTF-8");
    return ms;
  }

  @Bean
  public LocalValidatorFactoryBean validator() {
    LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
    factoryBean.setValidationMessageSource(messageSource());
    return factoryBean;
  }

  @Bean
  public WebMvcConfigurer webMvcConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public Validator getValidator() {
        return validator();
      }
    };
  }

}
