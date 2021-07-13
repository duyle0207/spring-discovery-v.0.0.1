package com.duylv.springdiscovery.mapper.base;

import org.mapstruct.*;

public interface EntityMapper<E, D> {

    D toDto(E e);

    E toEntity(D d);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void partialUpdate(@MappingTarget E e, D d);

}
