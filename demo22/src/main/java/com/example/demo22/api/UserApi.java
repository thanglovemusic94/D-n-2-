package com.example.demo22.api;

//import com.example.restuploadfile.dto.UserDTO;
//import com.example.restuploadfile.entity.UserEntity;
//import com.example.restuploadfile.repository.UserRepository;
//import com.example.restuploadfile.util.Converter;
//import com.example.restuploadfile.util.UploadUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping("/api/user")
public class UserApi {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    public Converter converter;
//
//    @Autowired
//    private UploadUtil uploadUtil;
//
//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }
//
//    @PostMapping ("/upload")
//    public ResponseEntity<UserEntity> uploadFile(@RequestBody UserDTO userDTO) throws UnsupportedEncodingException {
//        uploadUtil.writeFile(userDTO.getBase64(), "/image/"+ File.separator + userDTO.getNameImage());
//        UserEntity userEntity = converter.toEntity(userDTO);
//        userRepository.save(userEntity);
//        return ResponseEntity.ok().build();
//    }
}
