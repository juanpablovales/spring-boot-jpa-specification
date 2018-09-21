package com.isr.test.repository.builder;

import com.isr.test.dto.SearchCriteriaDTO;
import com.isr.test.enums.SearchOperationEnum;
import com.isr.test.model.AccessLogModel;
import java.util.Date;
import java.util.List;
import org.springframework.util.CollectionUtils;

/**
 * Created by gfs on 21/09/2018.
 * <p>
 *  This class is {@link AccessLogModel} instance specific Specification  builder.
 * </p>
 */
public class AccessLogSpecificationBuilder extends BaseSpecificationBuilder<AccessLogModel> {

  /**
   * Builder method for start date criteria
   * @param startDate
   * @return
   */
  public AccessLogSpecificationBuilder startDate(final Date startDate) {
    if (startDate != null) {
      filterList.add(new SearchCriteriaDTO("loginTime", startDate, SearchOperationEnum.AFTER));
    }
    return this;
  }

  /**
   * Builder method for end date criteria
   * @param endDate
   * @return
   */
  public AccessLogSpecificationBuilder endDate(final Date endDate) {
    if (endDate != null) {
      filterList.add(new SearchCriteriaDTO("loginTime", endDate, SearchOperationEnum.BEFORE));
    }
    return this;
  }

  /**
   *  Builder method for attribute1 criteria
   * @param attribute1
   * @return
   */
  public AccessLogSpecificationBuilder attribute1(final List<String> attribute1) {
    if (!CollectionUtils.isEmpty(attribute1)) {
      filterList.add(new SearchCriteriaDTO("attribute1", attribute1, SearchOperationEnum.IN));
    }
    return this;
  }

  /**
   *  Builder method for attribute2 criteria
   * @param attribute2
   * @return
   */
  public AccessLogSpecificationBuilder attribute2(final List<String> attribute2) {
    if (!CollectionUtils.isEmpty(attribute2)) {
      filterList.add(new SearchCriteriaDTO("attribute2", attribute2, SearchOperationEnum.IN));
    }
    return this;
  }

  /**
   *  Builder method for attribute3criteria
   * @param attribute3
   * @return
   */
  public AccessLogSpecificationBuilder attribute3(final List<String> attribute3) {
    if (!CollectionUtils.isEmpty(attribute3)) {
      filterList.add(new SearchCriteriaDTO("attribute3", attribute3, SearchOperationEnum.IN));
    }
    return this;
  }

  /**
   *  Builder method for attributecriteria
   * @param attribute4
   * @return
   */
  public AccessLogSpecificationBuilder attribute4(final List<String> attribute4) {
    if (!CollectionUtils.isEmpty(attribute4)) {
      filterList.add(new SearchCriteriaDTO("attribute4", attribute4, SearchOperationEnum.IN));
    }
    return this;
  }


}
