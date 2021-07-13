package com.duylv.springdiscovery.service;

import com.duylv.springdiscovery.dto.RoleDTO;
import com.duylv.springdiscovery.entity.Role;

public interface RoleService {

    Role save(RoleDTO roleDTO);
}
