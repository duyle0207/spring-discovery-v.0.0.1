package com.duylv.springdiscovery.service;

import com.duylv.springdiscovery.filter.StringFilter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.List;

public interface StringFilterService<T> {

    List<Predicate> buildPredicate(StringFilter stringFilter, SingularAttribute<? super T, ?> col,
                                   Root<T> root, CriteriaBuilder criteriaBuilder);

}
