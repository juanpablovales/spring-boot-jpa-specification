package com.isr.test.exception;

/**
 * Created by gfs on 21/09/2018.
 */
public class TestException extends RuntimeException {

  public TestException(final String msg) {
    super(msg);
  }

  public TestException(final String msg, final Throwable throwable) {
    super(msg, throwable);
  }

}
