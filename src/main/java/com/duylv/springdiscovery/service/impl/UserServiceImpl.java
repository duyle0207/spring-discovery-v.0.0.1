package com.duylv.springdiscovery.service.impl;

import com.duylv.springdiscovery.dto.UserCriteria;
import com.duylv.springdiscovery.dto.UserDTO;
import com.duylv.springdiscovery.entity.User;
import com.duylv.springdiscovery.entity.User_;
import com.duylv.springdiscovery.mapper.UserMapper;
import com.duylv.springdiscovery.repository.UserRepository;
import com.duylv.springdiscovery.service.FilterService;
import com.duylv.springdiscovery.service.UserService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final FilterService<User> filterService;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, FilterService<User> filterService) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.filterService = filterService;
    }

    @Override
    public UserDTO save(UserDTO userDto) {
        Optional<User> existUser = userRepository
                .findById(userDto.getId());

        if (existUser.isPresent()) { // partial update
            userMapper.partialUpdate(existUser.get(), userDto);
            return userMapper.toDto(userRepository.save(existUser.get()));
        } else { // create new one
            User user = userMapper.toEntity(userDto);
            user.getHomes().forEach(home -> home.setUser(user));
            return userMapper.toDto(userRepository.save(user));
        }
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByCriteria(UserCriteria userCriteria) {
        Specification<User> userSpecification = Specification.where(null);

        if (!Objects.isNull(userCriteria.getUsername())) {
            userSpecification = userSpecification.and(filterService.buildStringSpecification(userCriteria.getUsername(), User_.username));
        }

        if (!Objects.isNull(userCriteria.getName())) {
            userSpecification = userSpecification.and(filterService.buildStringSpecification(userCriteria.getName(), User_.name));
        }

        return userRepository.findAll(userSpecification).stream().map(userMapper::toDto).collect(Collectors.toList());
    }
}
