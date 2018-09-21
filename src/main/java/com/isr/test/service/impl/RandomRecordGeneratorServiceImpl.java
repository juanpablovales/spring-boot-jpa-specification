package com.isr.test.service.impl;

import com.isr.test.model.AccessLogModel;
import com.isr.test.repository.AccessLogRepository;
import com.isr.test.service.RandomRecordGeneratorService;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gfs on 21/09/2018.
 */
@Service
@Transactional
public class RandomRecordGeneratorServiceImpl implements RandomRecordGeneratorService {

  private static final String[] USERS = {
      "John Paul", "Romel", "Julius", "Toby", "Floyd", "Evelyn"
  };
  private static final String[] ATTRIBUTES = {
      "AA123", "AB123", "AC123", "AD123", "AE123", "AF123", "AG123"
  };
  private static final int DEFAULT_COUNT = 100000;

  private static final DateTime START_DATE = DateTime.now()
      .withMonthOfYear(9).withYear(2018).withDayOfMonth(1);
  private static final DateTime END_DATE = DateTime.now()
      .withMonthOfYear(9).withYear(2018).withDayOfMonth(20);

  @Autowired
  private AccessLogRepository accessLogRepository;

  @PersistenceContext
  private EntityManager em;

  @Override
  public void generate(int recordCount) {

    if (recordCount == 0) {
      recordCount = DEFAULT_COUNT;
    }

    for (int ctr = 1; ctr <= recordCount; ctr++) {
      AccessLogModel model = new AccessLogModel();
      model.setUser(USERS[(int) (Math.random() * USERS.length)]);
      model.setAttribute1(ATTRIBUTES[(int) (Math.random() * ATTRIBUTES.length)]);
      model.setAttribute2(ATTRIBUTES[(int) (Math.random() * ATTRIBUTES.length)]);
      model.setAttribute3(ATTRIBUTES[(int) (Math.random() * ATTRIBUTES.length)]);
      model.setAttribute4(ATTRIBUTES[(int) (Math.random() * ATTRIBUTES.length)]);
      model.setLoginTime(generateRandomDate());
      accessLogRepository.save(model);
      if ((ctr % 1000) == 0) {
        em.flush();
        em.clear();
      }

    }
  }

  private Date generateRandomDate() {
    return new Date(
        ThreadLocalRandom.current().nextLong(START_DATE.toDate().getTime(),
            END_DATE.toDate().getTime()));

  }

}
