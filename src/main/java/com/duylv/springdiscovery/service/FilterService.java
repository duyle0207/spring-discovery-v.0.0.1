package com.duylv.springdiscovery.service;

import com.duylv.springdiscovery.filter.StringFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.metamodel.SingularAttribute;

public interface FilterService<T> {

    Specification<T> buildStringSpecification(StringFilter stringFilter, SingularAttribute<? super T, String> col);

    Specification<T> buildNumberSpecification(StringFilter stringFilter, SingularAttribute<? super T, ?> col);

}
