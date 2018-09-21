package com.isr.test.repository.filter;

import com.isr.test.dto.SearchCriteriaDTO;
import com.isr.test.enums.SearchOperationEnum;
import java.sql.Date;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 * This is the base SpecificationFilter. This will build predicates based on the
 * {@link SearchCriteriaDTO} instance
 * provided.
 * Created by gfs on 21/09/2018.
 */
public class SpecificationFilter<T> implements Specification<T> {

  private SearchCriteriaDTO searchCriteriaDTO;

  public SpecificationFilter(SearchCriteriaDTO searchCriteriaDTO) {
    this.searchCriteriaDTO = searchCriteriaDTO;
  }

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery,
      CriteriaBuilder builder) {
    Path field = root.get(searchCriteriaDTO.getKey());
    if (SearchOperationEnum.BETWEEN.equals(searchCriteriaDTO.getOperation())) {
      return builder.between(field.as(Date.class), searchCriteriaDTO.getStartDateValue(),
          searchCriteriaDTO.getEndDateValue());
    } else if (SearchOperationEnum.BEFORE.equals(searchCriteriaDTO.getOperation())) {
      return builder.lessThanOrEqualTo(field.as(Date.class), searchCriteriaDTO.getEndDateValue());
    } else if (SearchOperationEnum.AFTER.equals(searchCriteriaDTO.getOperation())) {
      return builder.greaterThanOrEqualTo(field.as(Date.class),
          searchCriteriaDTO.getStartDateValue());
    } else if (SearchOperationEnum.IN.equals(searchCriteriaDTO.getOperation())) {
      In in = builder.in(field);
      searchCriteriaDTO.getValueList().forEach(in::value);
      return in;
    }

    return null;
  }


}
