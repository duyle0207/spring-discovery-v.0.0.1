package com.duylv.springdiscovery.service.impl;

import com.duylv.springdiscovery.entity.User;
import com.duylv.springdiscovery.entity.User_;
import com.duylv.springdiscovery.service.FilterHandler;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

@Service
public class FilterHandlerImpl<T> implements FilterHandler<T> {

    @Override
    public Predicate equal(SingularAttribute<? super T, ?> col, Object value, Root<T> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get(col.getName()), value);
    }

    @Override
    public Predicate in(SingularAttribute<? super T, ?> col, Object value, Root<T> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.in(root.get(col.getName())).value(value);
    }

    @Override
    public Predicate notIn(SingularAttribute<? super T, ?> col, Object value, Root<T> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.in(root.get(col.getName())).value(value).not();
    }

    @Override
    public Predicate like(SingularAttribute<? super T, ?> col, Object value, Root<T> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get(col.getName()), (String) value);
    }
}
