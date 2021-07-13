package com.duylv.springdiscovery.controller;

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

    @PostMapping("/user")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.save(userDTO));
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAllUser());
    }
}
