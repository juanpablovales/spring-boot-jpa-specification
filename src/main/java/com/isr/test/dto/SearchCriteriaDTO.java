package com.isr.test.dto;

import com.isr.test.enums.SearchOperationEnum;
import java.util.Date;
import java.util.List;

/**
 * This class is used for generating Predicatea  based on populated criterias.
 * Created by gfs on 20/09/2018.
 */
public class SearchCriteriaDTO {

  private String key;
  private String value;
  private Date startDateValue;
  private Date endDateValue;
  private List<String> valueList;
  private SearchOperationEnum operation;

  public SearchCriteriaDTO() {
  }


  /**
   * This constructor is for single comparison predicate for String and Numeric datatype
   *
   * @param key - field name
   * @param value - field value
   * @param operation - the operation to be used.
   */
  public SearchCriteriaDTO(final String key, final String value,
      final SearchOperationEnum operation) {
    this.key = key;
    this.value = value;
    this.operation = operation;
  }

  /**
   * This constructor is for IN comparison predicate for String
   *
   * @param key - field name
   * @param valueList - field values
   * @param operation - the operation to be used.
   */
  public SearchCriteriaDTO(final String key, final List<String> valueList,
      final SearchOperationEnum operation) {
    this.key = key;
    this.valueList = valueList;
    this.operation = operation;
  }

  /**
   * This constructor is for date comparison predicate
   *
   * @param key - field name
   * @param dateValue - field value
   * @param operation - the operation to be used. Normally BEFORE or AFTER
   */
  public SearchCriteriaDTO(final String key, final Date dateValue,
      final SearchOperationEnum operation) {
    this.key = key;
    this.startDateValue = dateValue;
    this.endDateValue = dateValue;
    this.operation = operation;
  }

  /**
   * This constructor is for between dates comparison predicate for
   *
   * @param key - field name
   * @param startDateValue - start date field value
   * @param endDateValue - end date field value
   * @param operation - the operation to be used.
   */
  public SearchCriteriaDTO(final String key, final Date startDateValue,
      final Date endDateValue, final SearchOperationEnum operation) {
    this.key = key;
    this.startDateValue = startDateValue;
    this.endDateValue = endDateValue;
    this.operation = operation;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

  public Date getStartDateValue() {
    return startDateValue;
  }

  public Date getEndDateValue() {
    return endDateValue;
  }

  public List<String> getValueList() {
    return valueList;
  }

  public SearchOperationEnum getOperation() {
    return operation;
  }
}
