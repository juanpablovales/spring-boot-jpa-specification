package com.isr.test.service;

import com.isr.test.TestApplication;
import com.isr.test.config.H2TestRepositoryConfig;
import com.isr.test.dto.BaseResponseDTO;
import com.isr.test.dto.request.AccessLogRequestDTO;
import com.isr.test.exception.TestException;
import com.isr.test.model.AccessLogModel;
import com.isr.test.repository.AccessLogRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gfs on 21/09/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestApplication.class, H2TestRepositoryConfig.class})
@Transactional
@Rollback
public class AccessLogServiceIntegrationTest {

  @Autowired
  private AccessLogRepository accessLogRepository;

  @Autowired
  private AccessLogService accessLogService;

  private AccessLogModel log1;
  private AccessLogModel log2;
  private AccessLogModel log3;
  private AccessLogModel log4;

  @Before
  public void init() {
    DateTime now = DateTime.now();
    log1 = new AccessLogModel();
    log1.setUser("John");
    log1.setLoginTime(now.withDayOfMonth(12).withMonthOfYear(8).toDate());
    log1.setAttribute1("GA123");
    log1.setAttribute2("GB123");
    log1.setAttribute3("GC123");
    log1.setAttribute4("GD123");
    accessLogRepository.save(log1);

    log2 = new AccessLogModel();
    log2.setUser("Paul");
    log2.setLoginTime(now.withDayOfMonth(13).withMonthOfYear(8).toDate());
    log2.setAttribute1("GA123");
    log2.setAttribute2("GA123");
    log2.setAttribute3("GA123");
    log2.setAttribute4("GA123");
    accessLogRepository.save(log2);

    log3 = new AccessLogModel();
    log3.setUser("Paul");
    log3.setLoginTime(now.withDayOfMonth(14).withMonthOfYear(8).toDate());
    log3.setAttribute1("GA123");
    log3.setAttribute2("GB123");
    log3.setAttribute3("GC123");
    log3.setAttribute4("GD123");
    accessLogRepository.save(log3);

    log4 = new AccessLogModel();
    log4.setUser("John");
    log4.setLoginTime(now.withDayOfMonth(15).withMonthOfYear(8).toDate());
    log4.setAttribute1("GA123");
    log4.setAttribute2("GB123");
    log4.setAttribute3("GC123");
    log4.setAttribute4("GD123");
    accessLogRepository.save(log4);
  }

  @AfterClass
  public static void after() {

  }

  @Test
  public void whenGettingDistinctDates_thenCorrect() {
    BaseResponseDTO response = accessLogService.findUniqueDates();
    List<String> data = (List<String>) response.getData();
    Assert.assertEquals(4, data.size());
  }


  @Test
  public void givenAttribute1_whenGettingLoginCount_thenCorrect() {
    AccessLogRequestDTO logRequestDTO = new AccessLogRequestDTO();
    List<String> attribute1 = new ArrayList<>();
    attribute1.add("GA123");
    logRequestDTO.setAttribute1(attribute1);
    BaseResponseDTO response = accessLogService.findUserAccessCountByFilter(logRequestDTO);
    Map<String, Long> data = (Map<String, Long>) response.getData();
    Assert.assertEquals(2, data.size());
    Assert.assertEquals(Long.valueOf(2), data.get("John"));
  }

  @Test
  public void givenStartDateAndEndDate_whenGettingLoginCount_thenCorrect() {
    AccessLogRequestDTO logRequestDTO = new AccessLogRequestDTO();
    logRequestDTO.setStart("20180813");
    logRequestDTO.setEnd("20180830");
    BaseResponseDTO response = accessLogService.findUserAccessCountByFilter(logRequestDTO);
    Map<String, Long> data = (Map<String, Long>) response.getData();
    Assert.assertEquals(2, data.size());
    Assert.assertEquals(Long.valueOf(2), data.get("Paul"));
  }

  @Test
  public void givenEndDate_whenGettingLoginCount_thenCorrect() {
    AccessLogRequestDTO logRequestDTO = new AccessLogRequestDTO();
    logRequestDTO.setEnd("20180814");
    BaseResponseDTO response = accessLogService.findUserAccessCountByFilter(logRequestDTO);
    Map<String, Long> data = (Map<String, Long>) response.getData();
    Assert.assertEquals(2, data.size());
    Assert.assertEquals(Long.valueOf(1), data.get("John"));
  }

  @Test
  public void givenStartDate_whenGettingLoginCount_thenCorrect() {
    AccessLogRequestDTO logRequestDTO = new AccessLogRequestDTO();
    logRequestDTO.setStart("20180815");
    BaseResponseDTO response = accessLogService.findUserAccessCountByFilter(logRequestDTO);
    Map<String, Long> data = (Map<String, Long>) response.getData();
    Assert.assertEquals(1, data.size());
    Assert.assertEquals(Long.valueOf(1), data.get("John"));
  }

  @Test
  public void givenAttribute2StartDateAndEndDate_whenGettingLoginCount_thenCorrect() {
    AccessLogRequestDTO logRequestDTO = new AccessLogRequestDTO();
    logRequestDTO.setStart("20180813");
    logRequestDTO.setEnd("20180830");
    List<String> attribute2 = new ArrayList<>();
    attribute2.add("GA123");
    logRequestDTO.setAttribute2(attribute2);
    BaseResponseDTO response = accessLogService.findUserAccessCountByFilter(logRequestDTO);
    Map<String, Long> data = (Map<String, Long>) response.getData();
    Assert.assertEquals(1, data.size());
    Assert.assertEquals(Long.valueOf(1), data.get("Paul"));
  }

  @Test
  public void givenStartDate_whenGettingUniqueUsers_thenCorrect() {
    AccessLogRequestDTO logRequestDTO = new AccessLogRequestDTO();
    logRequestDTO.setStart("20180815");
    BaseResponseDTO response = accessLogService.findUniqueUsersByDates(logRequestDTO);
    Set<String> data = (Set<String>) response.getData();
    Assert.assertEquals(1, data.size());
    Assert.assertTrue(data.contains("John"));
  }

  @Test
  public void givenStartDateAndEndDate_whenGettingUniqueUsers_thenCorrect() {
    AccessLogRequestDTO logRequestDTO = new AccessLogRequestDTO();
    logRequestDTO.setStart("20180812");
    logRequestDTO.setEnd("20180815");
    BaseResponseDTO response = accessLogService.findUniqueUsersByDates(logRequestDTO);
    Set<String> data = (Set<String>) response.getData();
    Assert.assertEquals(2, data.size());
    Assert.assertTrue(data.contains("John"));
    Assert.assertTrue(data.contains("Paul"));

  }

  @Test(expected = TestException.class)
  public void givenInvalidDateFormat_whenGettingUniqueUsers_thenException() {
    AccessLogRequestDTO logRequestDTO = new AccessLogRequestDTO();
    logRequestDTO.setStart("sssaewew");
    BaseResponseDTO response = accessLogService.findUniqueUsersByDates(logRequestDTO);
  }

  @Test(expected = TestException.class)
  public void givenInvalidDateFormat_whenGettingLoginCount_thenException() {
    AccessLogRequestDTO logRequestDTO = new AccessLogRequestDTO();
    logRequestDTO.setStart("sssaewew");
    BaseResponseDTO response = accessLogService.findUserAccessCountByFilter(logRequestDTO);
  }


}
