package com.example.restuploadfile.api;

import com.example.restuploadfile.dto.UserDTO;
import com.example.restuploadfile.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping("/api/user")
public class UserApi {

    @Autowired
    public UploadUtil uploadUtil;

    @GetMapping("/upload")
    public ResponseEntity<Void> uploadFile(@RequestBody UserDTO userDTO) throws UnsupportedEncodingException {
        uploadUtil.writeFile(userDTO.getBase64(), "/image/"+ File.separator + userDTO.getName());
        return ResponseEntity.noContent().build();
    }
}
