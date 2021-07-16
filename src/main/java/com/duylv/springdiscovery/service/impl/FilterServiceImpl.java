package com.duylv.springdiscovery.service.impl;

import com.duylv.springdiscovery.filter.StringFilter;
import com.duylv.springdiscovery.service.FilterService;
import com.duylv.springdiscovery.service.StringFilterService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilterServiceImpl<T> implements FilterService<T> {

    private final StringFilterService<T> stringFilterService;

    public FilterServiceImpl(StringFilterService<T> stringFilterService) {
        this.stringFilterService = stringFilterService;
    }

    /**
     * Build Specification for String's filter
     * @param stringFilter StringFilter
     * @param col column
     * @return Specification<T>
     */
    @Override
    public Specification<T> buildStringSpecification(StringFilter stringFilter, SingularAttribute<? super T, String> col) {
        return stringFilterService.build(stringFilter, root -> root.get(col));
    };

    // TODO
    @Override
    public Specification<T> buildNumberSpecification(StringFilter stringFilter, SingularAttribute<? super T, ?> col) {
        return null;
    }
}
