package com.duylv.springdiscovery.controller;

import com.duylv.springdiscovery.dto.UserCriteria;
import com.duylv.springdiscovery.dto.UserDTO;
import com.duylv.springdiscovery.dto.response.BaseResponseDTO;
import com.duylv.springdiscovery.entity.User;
import com.duylv.springdiscovery.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<UserDTO> saveUser(UserDTO userDTO) {
        return ResponseEntity.ok(userService.save(userDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/filter")
    public ResponseEntity<List<UserDTO>> filter(UserCriteria userCriteria) {
        return ResponseEntity.ok(userService.findByCriteria(userCriteria));
    }

    @PostMapping("/user_has_home")
    public ResponseEntity<List<UserDTO>> filter() {
        return ResponseEntity.ok(userService.findUserHasHome());
    }
}
