package com.duylv.springdiscovery.mapper;

import com.duylv.springdiscovery.dto.HomeDTO;
import com.duylv.springdiscovery.dto.RoleDTO;
import com.duylv.springdiscovery.entity.Home;
import com.duylv.springdiscovery.entity.Role;
import com.duylv.springdiscovery.mapper.base.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {UserMapper.class}
)
public interface HomeMapper  extends EntityMapper<Home, HomeDTO> {

    @Override
    @Mapping(source = "user.id", target = "userId")
    HomeDTO toDto(Home home);

    @Override
    @Mapping(source = "userId", target = "user.id")
    Home toEntity(HomeDTO homeDTO);
}
