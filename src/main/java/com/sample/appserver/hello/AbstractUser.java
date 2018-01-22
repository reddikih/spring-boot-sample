package com.sample.appserver.hello;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by satoshi on 2018/01/22.
 */
@MappedSuperclass
public class AbstractUser implements Serializable {

  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;
  @Column(name = "sexuality")
  private String sexuality;
  @Column(name = "birth_year")
  private Integer birthYear;
  @Column(name = "prefecture")
  private String prefecture;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSexuality() {
    return sexuality;
  }

  public void setSexuality(String sexuality) {
    this.sexuality = sexuality;
  }

  public Integer getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(Integer birthYear) {
    this.birthYear = birthYear;
  }

  public String getPrefecture() {
    return prefecture;
  }

  public void setPrefecture(String prefecture) {
    this.prefecture = prefecture;
  }
}
