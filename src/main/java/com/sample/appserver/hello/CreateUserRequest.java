package com.sample.appserver.hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * Created by satoshi on 2018/01/22.
 */
public class CreateUserRequest {
  @JsonProperty("user_id")
  public String userId;
  @JsonProperty("email")
  public String email;
  @JsonProperty("password")
  public String password;
  @JsonProperty("sexuality")
  public String sexuality;
  @JsonProperty("birth_year")
  public Integer birth_year;
  @JsonProperty("prefecture")
  public String prefecture;

  public CreateUserRequest(String userId, String email, String password,
      String sexuality, Integer birth_year, String prefecture) {
    this.userId = userId;
    this.email = email;
    this.password = password;
    this.sexuality = sexuality;
    this.birth_year = birth_year;
    this.prefecture = prefecture;
  }

}
