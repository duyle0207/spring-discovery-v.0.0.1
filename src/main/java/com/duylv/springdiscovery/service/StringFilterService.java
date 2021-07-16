package com.duylv.springdiscovery.service;

import com.duylv.springdiscovery.filter.StringFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.List;
import java.util.function.Function;

public interface StringFilterService<T> {

    <X> Specification<T> build(StringFilter stringFilter, Function<Root<T>, Expression<String>> metaClassFunction);

}
