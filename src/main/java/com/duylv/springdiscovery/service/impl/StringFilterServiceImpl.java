package com.duylv.springdiscovery.service.impl;

import com.duylv.springdiscovery.filter.StringFilter;
import com.duylv.springdiscovery.service.FilterHandler;
import com.duylv.springdiscovery.service.StringFilterService;
import com.duylv.springdiscovery.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StringFilterServiceImpl<T> implements StringFilterService<T> {

    private final FilterHandler<T> filterHandler;

    public StringFilterServiceImpl(FilterHandler<T> filterHandler) {
        this.filterHandler = filterHandler;
    }

    @Override
    public List<Predicate> buildPredicate(StringFilter stringFilter, SingularAttribute<? super T, ?> col,
                                          Root<T> root, CriteriaBuilder criteriaBuilder) {

        List<Predicate> strPredicateList = new ArrayList<>();

        if (!Objects.isNull(stringFilter.getContain())) {
            strPredicateList.add(filterHandler.in(col, stringFilter.getContain(), root, criteriaBuilder));
        }

        if (!Objects.isNull(stringFilter.getEqual())) {
            strPredicateList.add(filterHandler.equal(col, stringFilter.getEqual(), root, criteriaBuilder));
        }

        if (!Objects.isNull(stringFilter.getLike())) {
            strPredicateList.add(filterHandler.like(col, StringUtil.customLikeKeyword(stringFilter.getLike()), root, criteriaBuilder));
        }

        if (!Objects.isNull(stringFilter.getStartWith())) {
            strPredicateList.add(filterHandler.like(col, StringUtil.customStartWithKeyword(stringFilter.getStartWith()), root, criteriaBuilder));
        }

        if (!Objects.isNull(stringFilter.getEndWith())) {
            strPredicateList.add(filterHandler.like(col, StringUtil.customEndWithKeyword(stringFilter.getEndWith()), root, criteriaBuilder));
        }

        return strPredicateList;
    }
}
