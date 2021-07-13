package com.duylv.springdiscovery.service.impl;

import com.duylv.springdiscovery.dto.RoleDTO;
import com.duylv.springdiscovery.entity.Role;
import com.duylv.springdiscovery.mapper.RoleMapper;
import com.duylv.springdiscovery.repository.RoleRepository;
import com.duylv.springdiscovery.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public Role save(RoleDTO roleDTO) {
        Role role = roleMapper.toEntity(roleDTO);
        return roleRepository.save(role);
    }
}
