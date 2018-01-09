package com.sample.appserver.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.appserver.validation.Password;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by satoshi on 2017/11/07.
 */
public class UserCredential {

  @NotNull
  @Size(min = 4, max = 15)
  @Pattern(regexp = "[0-9a-zA-Z_]+")
  @JsonProperty("user_id")
  public String userId;

  //	@NotNull
//  @Size(min = 7, max = 32)
  @Password
  @JsonProperty("password")
  public String password;

}
