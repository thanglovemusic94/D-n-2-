package com.example.restuploadfile.api;

import com.example.restuploadfile.dto.UserDTO;
import com.example.restuploadfile.entity.UserEntity;
import com.example.restuploadfile.repository.UserRepository;
import com.example.restuploadfile.util.Converter;
import com.example.restuploadfile.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserApi {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public Converter converter;

    @Autowired
    private UploadUtil uploadUtil;


    @PostMapping ("/upload")
    public ResponseEntity<?> uploadFile(@RequestBody UserDTO userDTO) {
        String path = File.separator +"image"+ File.separator + userDTO.getNameImage();
        uploadUtil.writeFile(userDTO.getBase64(), path);
        UserEntity userEntity = converter.toEntity(userDTO);
        userEntity.setNameImage(path);
        userRepository.save(userEntity);
        return ResponseEntity.ok().build();
    }

    @GetMapping ("/upload")
    public ResponseEntity<List<UserDTO>> uploadFile1() {
        List<UserEntity> listEntity = userRepository.findAll();
        List<UserDTO> userDTO = new ArrayList<>();
        for (UserEntity userEntity : listEntity) {
            userDTO.add(converter.toDTO(userEntity));
        }
        return new ResponseEntity<List<UserDTO>>(userDTO, HttpStatus.OK);
    }
}
