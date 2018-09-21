package com.isr.test.repository;

import com.isr.test.model.AccessLogModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by gfs on 17/09/2018.
 */
@Repository
public interface AccessLogRepository extends JpaRepository<AccessLogModel, Long>,
    JpaSpecificationExecutor {

  @Query(nativeQuery = true, value = "SELECT DISTINCT CAST(CAST(login_time as DATE) AS char)"
      + " FROM access_log")
  List<String> findDistinctDates();

}
