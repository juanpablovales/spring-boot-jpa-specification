package com.isr.test.service.impl;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import com.isr.test.dto.BaseResponseDTO;
import com.isr.test.dto.request.AccessLogRequestDTO;
import com.isr.test.exception.TestException;
import com.isr.test.model.AccessLogModel;
import com.isr.test.repository.AccessLogRepository;
import com.isr.test.repository.builder.AccessLogSpecificationBuilder;
import com.isr.test.service.AccessLogService;
import com.isr.test.util.DateUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * Created by gfs on 19/09/2018.
 */
@Service
public class AccessLogServiceImpl implements AccessLogService {

  private static final String DATE_FORMAT = "yyyyMMdd";

  @Autowired
  private AccessLogRepository accessLogRepository;

  @Override
  public BaseResponseDTO findUniqueUsersByDates(final AccessLogRequestDTO accessLogRequestDTO) {
    Sort sort = Sort.by(Direction.ASC, "loginTime");
    List<AccessLogModel> result = findBySpecifications(accessLogRequestDTO, sort);
    Set<String> users = new HashSet<>();
    result.removeIf(p -> !users.add(p.getUser()));
    return new BaseResponseDTO().withData(users.stream().sorted().collect(Collectors.toSet()))
        .withStatus(true).withMessage("Success");
  }

  @Override
  public BaseResponseDTO findUniqueDates() {
    List<String> accessLogs = accessLogRepository.findDistinctDates();

    return new BaseResponseDTO().withData(accessLogs.stream().sorted().collect(Collectors.toList()))
        .withStatus(true).withMessage("Success");
  }

  @Override
  public BaseResponseDTO findUserAccessCountByFilter(
      final AccessLogRequestDTO accessLogRequestDTO) {
    List<AccessLogModel> result = findBySpecifications(accessLogRequestDTO, null);

    Map<String, Long> map = result.stream()
        .collect(groupingBy(AccessLogModel::getUser, counting()));

    return new BaseResponseDTO().withData(map).withStatus(true).withMessage("Success");
  }

  private List<AccessLogModel> findBySpecifications(final AccessLogRequestDTO requestDTO,
      final Sort sort) {
    AccessLogSpecificationBuilder paramBuilderDTO = new AccessLogSpecificationBuilder();
    try {
      paramBuilderDTO.startDate(DateUtil.parse(DATE_FORMAT, requestDTO.getStart()));
      paramBuilderDTO.endDate(DateUtil.parse(DATE_FORMAT, requestDTO.getEnd()));
    } catch (ParseException ex) {
      throw new TestException("Date should be in this format: " + DATE_FORMAT);
    }
    paramBuilderDTO.attribute1(requestDTO.getAttribute1());
    paramBuilderDTO.attribute2(requestDTO.getAttribute2());
    paramBuilderDTO.attribute3(requestDTO.getAttribute3());
    paramBuilderDTO.attribute4(requestDTO.getAttribute4());

    List<AccessLogModel> result = new ArrayList<>();
    if (sort == null) {
      result = accessLogRepository.findAll(paramBuilderDTO.build());
    } else {
      result = accessLogRepository.findAll(paramBuilderDTO.build(), sort);

    }

    return result;
  }


}
