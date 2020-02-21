package com.example.restuploadfile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO implements Serializable {
    private Long id;
//    private String base64; // truyen vao base64
    private String nameImage; // ten file

//    public String getBase64() {
//        return this.base64.split(",")[1];
//    }
}
