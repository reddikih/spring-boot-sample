package com.sample.appserver.hello;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by satoshi on 2018/01/21.
 */
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user")
public class User extends AbstractUser {

  @Id
  @Column(name = "user_id")
  private String userId;


  protected User() {
  }

  public User(String userId, String email, String password,
      String sexuality, Integer birthYear, String prefecture) {
    setUserId(userId);
    setEmail(email);
    setPassword(password);
    setSexuality(sexuality);
    setBirthYear(birthYear);
    setPrefecture(prefecture);
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

}
