package com.duylv.springdiscovery.service.impl;

import com.duylv.springdiscovery.filter.StringFilter;
import com.duylv.springdiscovery.service.FilterHandler;
import com.duylv.springdiscovery.service.StringFilterService;
import com.duylv.springdiscovery.util.StringUtil;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Service
public class StringFilterServiceImpl<T> implements StringFilterService<T> {

    private final FilterHandler<T> filterHandler;

    public StringFilterServiceImpl(FilterHandler<T> filterHandler) {
        this.filterHandler = filterHandler;
    }

    @Override
    public <X> Specification<T> build(StringFilter stringFilter, Function<Root<T>, Expression<String>> metaClassFunction) {
        if (!Objects.isNull(stringFilter.getContain())) {
            return filterHandler.in(metaClassFunction, stringFilter.getContain());
        }

        if (!Objects.isNull(stringFilter.getEqual())) {
            return filterHandler.equal(metaClassFunction, String.valueOf(stringFilter.getEqual()));
        }

        if (!Objects.isNull(stringFilter.getLike())) {
            return filterHandler.like(metaClassFunction, StringUtil.customLikeKeyword(stringFilter.getLike()));
        }

        if (!Objects.isNull(stringFilter.getStartWith())) {
            return filterHandler.like(metaClassFunction, StringUtil.customStartWithKeyword(stringFilter.getStartWith()));
        }

        if (!Objects.isNull(stringFilter.getEndWith())) {
            return filterHandler.like(metaClassFunction, StringUtil.customEndWithKeyword(stringFilter.getEndWith()));
        }

        return null;
    }

}
