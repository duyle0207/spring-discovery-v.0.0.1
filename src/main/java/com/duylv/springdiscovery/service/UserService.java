package com.duylv.springdiscovery.service;

import com.duylv.springdiscovery.dto.UserDTO;
import com.duylv.springdiscovery.dto.UserCriteria;
import com.duylv.springdiscovery.entity.Home;

import java.util.List;

public interface UserService {

    UserDTO save(UserDTO userDto);

    List<UserDTO> findAll();

    List<UserDTO> findByCriteria(UserCriteria userCriteria);

    List<UserDTO> findUserHasHome();
}
