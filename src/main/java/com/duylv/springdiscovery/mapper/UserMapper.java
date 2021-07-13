package com.duylv.springdiscovery.mapper;

import com.duylv.springdiscovery.dto.UserDTO;
import com.duylv.springdiscovery.entity.User;
import com.duylv.springdiscovery.mapper.base.EntityMapper;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {HomeMapper.class, RoleMapper.class})
public interface UserMapper extends EntityMapper<User, UserDTO> {

    @Override
    UserDTO toDto(User e);

    @Override
    User toEntity(UserDTO d);

}
