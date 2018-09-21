package com.isr.test.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Created by gfs on 21/09/2018.
 */
@JsonInclude(Include.NON_NULL)
public class BaseResponseDTO<T> {

  private String message;
  private boolean success;
  private T data;

  public String getMessage() {
    return message;
  }

  public boolean isSuccess() {
    return success;
  }

  public T getData() {
    return data;
  }

  public BaseResponseDTO<T> withMessage(String message) {
    this.message = message;
    return this;
  }

  public BaseResponseDTO<T> withStatus(boolean success) {
    this.success = success;
    return this;
  }

  public BaseResponseDTO<T> withData(T data) {
    this.data = data;
    return this;
  }
}
