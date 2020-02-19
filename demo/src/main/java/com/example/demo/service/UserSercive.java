package com.example.demo.service;


import com.example.demo.dto.UserDTO;

import java.util.List;
import java.util.Optional;


public interface UserSercive {
    List<UserDTO> findAll();
    Optional<UserDTO> findById(Integer id);
    Optional<UserDTO> findByUsername(String username);
    UserDTO save(UserDTO UserDTO);
    void delete(Integer id);
    void deleteAll(List<String> ids);
}
