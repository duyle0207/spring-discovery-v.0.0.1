package com.duylv.springdiscovery.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

public interface FilterHandler<T> {

    Predicate equal(SingularAttribute<? super T,?> col, Object value, Root<T> root, CriteriaBuilder criteriaBuilder);

    Predicate in(SingularAttribute<? super T, ?> col, Object value, Root<T> root, CriteriaBuilder criteriaBuilder);

    Predicate notIn(SingularAttribute<? super T,?> col, Object value, Root<T> root, CriteriaBuilder criteriaBuilder);

    Predicate like(SingularAttribute<? super T,?> col, Object value, Root<T> root, CriteriaBuilder criteriaBuilder);
}
