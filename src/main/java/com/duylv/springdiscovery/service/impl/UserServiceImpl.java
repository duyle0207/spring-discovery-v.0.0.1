package com.duylv.springdiscovery.service.impl;

import com.duylv.springdiscovery.dto.UserCriteria;
import com.duylv.springdiscovery.dto.UserDTO;
import com.duylv.springdiscovery.entity.QHome;
import com.duylv.springdiscovery.entity.QUser;
import com.duylv.springdiscovery.entity.User;
import com.duylv.springdiscovery.entity.User_;
import com.duylv.springdiscovery.mapper.UserMapper;
import com.duylv.springdiscovery.repository.UserRepository;
import com.duylv.springdiscovery.service.FilterService;
import com.duylv.springdiscovery.service.UserService;
import com.duylv.springdiscovery.specification.JoinService;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final FilterService<User> filterService;

    @PersistenceContext
    private EntityManager entityManager;

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

        // userSpecification = userSpecification.and(joinService.joinHandler());
        return userRepository.findAll(userSpecification).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findUserHasHome() {

        JPAQuery<User> query = new JPAQuery<>(entityManager);

        QUser qUser = QUser.user;
        QHome qHome = QHome.home;

         List<UserDTO> users = query
                 .from(qUser)
                 .leftJoin(qUser.homes, qHome)
                 .on(qHome.address.eq("Duy"))
                 .groupBy(QUser.user.id)
                 .select(
                         qUser.id,
                         qUser.username,
                         qUser.name,
                         qHome.address
                 )
                 .fetch()
                 .stream()
                 .map(user -> new UserDTO(user.get(qUser.id),
                         user.get(qUser.username),
                         user.get(qUser.name),
                         !Objects.isNull(user.get(qHome.address))))
                 .collect(Collectors.toList());;

        return users;
    }

}
