package com.isr.test.web;

import com.isr.test.service.RandomRecordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gfs on 21/09/2018.
 */
@RestController
@RequestMapping("/generate")
public class RandomRecordGeneratorController {


  @Autowired
  private RandomRecordGeneratorService randomRecordGeneratorService;

  /**
   * This endpoint is for populating the access_logs table
   * @param recordCount - numnber of records to generate
   */
  @GetMapping
  public void generate(@RequestParam(value = "recordCount", required = false) Integer recordCount) {
    randomRecordGeneratorService.generate(recordCount);

  }
}
