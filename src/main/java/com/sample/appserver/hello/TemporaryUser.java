package com.sample.appserver.hello;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by satoshi on 2018/01/22.
 */
@Entity
@Table(name = "user_registration")
//public class TemporaryUser extends User {
public class TemporaryUser extends AbstractUser {

  @Id
  @Column(name = "register_id")
  private String registerId;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "status")
  private String status;

  protected TemporaryUser() {
    super();
  }

  public TemporaryUser(String registerId, String userId, String status) {
    this.registerId = registerId.toString();
    this.userId = userId;
    this.status = status;
  }

  public String getRegisterId() {
    return registerId;
  }

  public void setRegisterId(String registerId) {
    this.registerId = registerId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
