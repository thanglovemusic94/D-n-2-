package com.example.demo.service;


import com.example.demo.dto.UserDTO;

import java.util.List;
import java.util.Optional;


public interface UserSercive {
    List<UserDTO> findAllUser();
    Optional<UserDTO> findById(Integer id);
    UserDTO save(UserDTO UserDTO);
    void delete(UserDTO UserDTO);
}
