package com.example.demo.controller.api;

import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserSercive;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserApi {

    @Autowired
    private UserSercive userSercive;

    @GetMapping
    public List<UserDTO> findAll() {
        return userSercive.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Integer id) {
        Optional<UserDTO> userDTO = userSercive.findById(id);
        return userDTO.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@RequestBody UserDTO dto) {
        return userSercive.save(dto);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@PathVariable Integer id, @RequestBody UserDTO dto) {
        Optional<UserDTO> userDTO = userSercive.findById(id);
        if (!userDTO.isPresent()) {
            System.out.println(" id  is not existed");
        }
        userDTO.get().setUsername(dto.getUsername());
        userDTO.get().setAvatar(dto.getAvatar());
        return userSercive.save(userDTO.get());
    }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Integer id) {
//        Optional<UserDTO> userDTO = userSercive.findById(id);
//        if (!userDTO.isPresent()) {
//            System.out.println(" id  is not existed");
//        }
//        userSercive.delete(id);
//    }

    @DeleteMapping("/{ids}")
    public void remove(@PathVariable List<String> ids) {
        userSercive.deleteAll(ids);
    }

}
