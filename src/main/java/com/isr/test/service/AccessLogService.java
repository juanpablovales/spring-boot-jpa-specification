package com.isr.test.service;

import com.isr.test.dto.BaseResponseDTO;
import com.isr.test.dto.request.AccessLogRequestDTO;
import com.isr.test.exception.TestException;

/**
 * Created by gfs on 21/09/2018.
 */
public interface AccessLogService {

  /**
   * This method is for getting the unique users based on the provided dates in request DTO
   * @param accessLogRequestDTO - dto for request params
   * @return the dto containing the list of users in the data field
   * @throws TestException
   */
  BaseResponseDTO findUniqueUsersByDates(final AccessLogRequestDTO accessLogRequestDTO)
      throws TestException;

  /**
   * This method is for getting the unique dates in the access_log table.
   * @return the dto containing the list of dates in the data field.
   */
  BaseResponseDTO findUniqueDates();

  /**
   * This method is for getting the login count of a user based on the search criteria provided.
   * @param accessLogRequestDTO - request dto containing the search criteria,
   * @return the dto containing the list of users and login count in the data field.
   * @throws TestException
   */
  BaseResponseDTO findUserAccessCountByFilter(final AccessLogRequestDTO accessLogRequestDTO)
      throws TestException;

}
