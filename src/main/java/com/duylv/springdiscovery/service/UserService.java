package com.duylv.springdiscovery.service;

import com.duylv.springdiscovery.dto.UserDTO;
import com.duylv.springdiscovery.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User save(UserDTO userDto);

    List<UserDTO> findAll();

    List<UserDTO> findAllUser();
}
