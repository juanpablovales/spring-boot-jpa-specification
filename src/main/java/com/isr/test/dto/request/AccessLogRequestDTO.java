package com.isr.test.dto.request;

import java.util.List;

/**
 * Created by gfs on 21/09/2018.
 *<p>
 * This class will handle the request parameters for AccessLogController
 *</p>
 */
public class AccessLogRequestDTO {

  /**
   * The string representing the start date criteria in YYYYMMDD format.
   */
  private String start;

  /**
   * The string representing the end date criteria in YYYYMMDD format.
   */
  private String end;

  /**
   * The list of string representing the attribute1 criteria.
   */
  private List<String> attribute1;

  /**
   * The list of string representing the attribute2 criteria.
   */
  private List<String> attribute2;

  /**
   * The list of string representing the attribute3 criteria.
   */
  private List<String> attribute3;

  /**
   * The list of string representing the attribute4 criteria.
   */
  private List<String> attribute4;

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public List<String> getAttribute1() {
    return attribute1;
  }

  public void setAttribute1(List<String> attribute1) {
    this.attribute1 = attribute1;
  }

  public List<String> getAttribute2() {
    return attribute2;
  }

  public void setAttribute2(List<String> attribute2) {
    this.attribute2 = attribute2;
  }

  public List<String> getAttribute3() {
    return attribute3;
  }

  public void setAttribute3(List<String> attribute3) {
    this.attribute3 = attribute3;
  }

  public List<String> getAttribute4() {
    return attribute4;
  }

  public void setAttribute4(List<String> attribute4) {
    this.attribute4 = attribute4;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("AccessLogRequestDTO{");
    sb.append("start='").append(start).append('\'');
    sb.append(", end='").append(end).append('\'');
    sb.append(", attribute1=").append(attribute1);
    sb.append(", attribute2=").append(attribute2);
    sb.append(", attribute3=").append(attribute3);
    sb.append(", attribute4=").append(attribute4);
    sb.append('}');
    return sb.toString();
  }
}
