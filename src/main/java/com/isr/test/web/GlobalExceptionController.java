package com.isr.test.web;

import com.isr.test.dto.BaseResponseDTO;
import com.isr.test.exception.TestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by gfs on 21/09/2018.
 */
@ControllerAdvice
public class GlobalExceptionController {

  private static final Logger _LOG = LoggerFactory
      .getLogger(GlobalExceptionController.class);

  /**
   * Exception Handler for TestException
   */
  @ExceptionHandler(TestException.class)
  public ResponseEntity<BaseResponseDTO> handleTestException(TestException ex) {
    _LOG.error(ex.getMessage(), ex);
    BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
    baseResponseDTO.withStatus(false);
    baseResponseDTO.withMessage(ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(baseResponseDTO);
  }

  /**
   * Exception Handler for TestException
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<BaseResponseDTO> handleGlobalException(Exception ex) {
    _LOG.error(ex.getMessage(), ex);
    BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
    baseResponseDTO.withStatus(false);
    baseResponseDTO.withMessage("Server Error.");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(baseResponseDTO);
  }

}
