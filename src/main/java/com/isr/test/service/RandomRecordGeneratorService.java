package com.isr.test.service;

/**
 * Created by gfs on 21/09/2018.
 */
public interface RandomRecordGeneratorService {

  /**
   * This method is for generating random records in the database.
   * If recordCount is 0, the default of 100,000 will be generated
   */
  void generate(Integer recordCount);

}
