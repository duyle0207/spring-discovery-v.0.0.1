package com.duylv.springdiscovery.controller;

import com.duylv.springdiscovery.dto.RoleDTO;
import com.duylv.springdiscovery.dto.UserDTO;
import com.duylv.springdiscovery.entity.Role;
import com.duylv.springdiscovery.entity.User;
import com.duylv.springdiscovery.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role")
    public ResponseEntity<RoleDTO> save(RoleDTO userDTO) {
        return ResponseEntity.ok(roleService.save(userDTO));
    }
}
