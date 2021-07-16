package com.duylv.springdiscovery.service.impl;

import com.duylv.springdiscovery.entity.User;
import com.duylv.springdiscovery.entity.User_;
import com.duylv.springdiscovery.service.FilterHandler;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.function.Function;

@Service
public class FilterHandlerImpl<T> implements FilterHandler<T> {

    @Override
    public <X> Specification<T> equal(Function<Root<T>, Expression<X>> metaClassFunction, String value) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(metaClassFunction.apply(root), value);
    }

    @Override
    public <X> Specification<T> in(Function<Root<T>, Expression<X>> metaClassFunction, String value) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.in(metaClassFunction.apply(root)).value((X) value);
    }

    @Override
    public <X> Specification<T> notIn(Function<Root<T>, Expression<X>> metaClassFunction, String value) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.in(metaClassFunction.apply(root)).value((X) value).not();
    }

    @Override
    public <X> Specification<T> like(Function<Root<T>, Expression<String>> metaClassFunction, String value) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(metaClassFunction.apply(root), value);
    }
}
