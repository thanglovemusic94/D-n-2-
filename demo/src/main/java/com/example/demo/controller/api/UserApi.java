package com.example.demo.controller.api;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserApi {

    @Autowired
    private UserSercive userSercive;

    @GetMapping("/user")
    public List<UserDTO> getAllUser() {
        return userSercive.findAllUser();
    }

    @PostMapping("/user")
    public UserDTO add(@RequestBody UserDTO dto) {
        return userSercive.save(dto);
    }
}
