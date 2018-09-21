package com.isr.test.web;

import com.isr.test.dto.request.AccessLogRequestDTO;
import com.isr.test.service.impl.AccessLogServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gfs on 19/09/2018.
 */

@RestController
@RequestMapping("/test")
public class AccessLogController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AccessLogController.class);

  @Autowired
  private AccessLogServiceImpl accessLogService;

  @GetMapping("/dates")
  public ResponseEntity getUniqueDates() {
    return ResponseEntity.ok().body(accessLogService.findUniqueDates());
  }

  @GetMapping("/users")
  public ResponseEntity getUniqueUsers(AccessLogRequestDTO requestDTO) {
    LOGGER.info(requestDTO.toString());
    return ResponseEntity.ok().body(accessLogService.findUniqueUsersByDates(requestDTO));
  }

  @GetMapping("/logins")
  public ResponseEntity getUserLoginCount(AccessLogRequestDTO requestDTO) {
    LOGGER.info(requestDTO.toString());
    return ResponseEntity.ok().body(accessLogService.findUserAccessCountByFilter(requestDTO));
  }


}
