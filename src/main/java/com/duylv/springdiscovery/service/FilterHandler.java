package com.duylv.springdiscovery.service;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.function.Function;

public interface FilterHandler<T> {

    <X> Specification<T> equal(Function<Root<T>, Expression<X>> metaClassFunction, String value);

    <X> Specification<T> in(Function<Root<T>, Expression<X>> metaClassFunction, String value);

    <X> Specification<T> notIn(Function<Root<T>, Expression<X>> metaClassFunction, String value);

    <X> Specification<T> like(Function<Root<T>, Expression<String>> metaClassFunction, String value);
}
