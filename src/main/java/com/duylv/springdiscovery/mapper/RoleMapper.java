package com.duylv.springdiscovery.mapper;

import com.duylv.springdiscovery.dto.RoleDTO;
import com.duylv.springdiscovery.entity.Role;
import com.duylv.springdiscovery.mapper.base.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RoleMapper extends EntityMapper<Role, RoleDTO> {

    @Override
    RoleDTO toDto(Role e);

    @Override
    Role toEntity(RoleDTO d);

}
