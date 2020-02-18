package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserSercive;
import com.example.demo.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserSerciveImpl implements UserSercive {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> listDTO = new ArrayList<>();
        List<UserEntity> listEntity = userRepository.findAll();
        for (UserEntity entity : listEntity) {
            listDTO.add(Converter.toDTO(entity));
        }
        return listDTO;
    }

    @Override
    public Optional<UserDTO> findById(Integer id) {
        UserEntity userEntity = userRepository.findById(id).get();
        UserDTO userDTO = Converter.toDTO(userEntity);
        return Optional.ofNullable(userDTO);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity userEntity = Converter.toEntity(userDTO);
        userRepository.save(userEntity);
        userDTO.setId(userEntity.getId());
        return userDTO;
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        for (String id: ids) {
            userRepository.deleteById(Integer.valueOf(id));
        }
    }
}
