package com.isr.test.model;

import com.isr.test.model.enums.FieldNameEnum;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by gfs on 17/09/2018.
 */
@Table(name = "access_log")
@Entity
public class AccessLogModel extends AbstractBaseModel {

  @Column(name = FieldNameEnum.ACCESS_LOG_USER, nullable = false, length = 20)
  private String user;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = FieldNameEnum.ACCESS_LOG_LOGIN_TIME, nullable = false, length = 20)
  private Date loginTime;

  @Column(name = FieldNameEnum.ACCESS_LOG_ATTR_1, length = 20)
  private String attribute1;

  @Column(name = FieldNameEnum.ACCESS_LOG_ATTR_2, length = 20)
  private String attribute2;

  @Column(name = FieldNameEnum.ACCESS_LOG_ATTR_3, length = 20)
  private String attribute3;

  @Column(name = FieldNameEnum.ACCESS_LOG_ATTR_4, length = 20)
  private String attribute4;


  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
  }

  public String getAttribute1() {
    return attribute1;
  }

  public void setAttribute1(String attribute1) {
    this.attribute1 = attribute1;
  }

  public String getAttribute2() {
    return attribute2;
  }

  public void setAttribute2(String attribute2) {
    this.attribute2 = attribute2;
  }

  public String getAttribute3() {
    return attribute3;
  }

  public void setAttribute3(String attribute3) {
    this.attribute3 = attribute3;
  }

  public String getAttribute4() {
    return attribute4;
  }

  public void setAttribute4(String attribute4) {
    this.attribute4 = attribute4;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("AccessLogModel{");
    sb.append("user='").append(user).append('\'');
    sb.append(", loginTime=").append(loginTime);
    sb.append(", attribute1='").append(attribute1).append('\'');
    sb.append(", attribute2='").append(attribute2).append('\'');
    sb.append(", attribute3='").append(attribute3).append('\'');
    sb.append(", attribute4='").append(attribute4).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
