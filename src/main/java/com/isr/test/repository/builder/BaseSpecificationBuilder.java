package com.isr.test.repository.builder;

import com.isr.test.dto.SearchCriteriaDTO;
import com.isr.test.repository.filter.SpecificationFilter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by gfs on 21/09/2018.
 * <p>
 * This is the base class for Specification builder. All class using specifications should
 * extend this to model specific builder.
 * </p>
 */
public abstract class BaseSpecificationBuilder<T> {

  protected List<SearchCriteriaDTO> filterList = new ArrayList<>();

  /**
   * Builder method responsible for combining all geenrated predicates
   * @return
   */
  public Specification<T> build() {
    if (filterList.size() == 0) {
      return null;
    }

    List<Specification<T>> specs = new ArrayList<>();
    for (SearchCriteriaDTO param : filterList) {
      specs.add(new SpecificationFilter(param));
    }

    Specification<T> result = specs.get(0);
    for (int i = 1; i < specs.size(); i++) {

      result = result.and(specs.get(i));
    }
    return result;
  }

}
