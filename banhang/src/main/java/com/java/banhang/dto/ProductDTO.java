package com.java.banhang.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("tensanpham")
    private String tensanpham;

    @JsonProperty("image")
    private MultipartFile image;

    @JsonProperty("imageBase64")
    private String imageBase64;

    @JsonProperty("gia")
    private String gia;

    @JsonProperty("giamgia")
    private Long giamgia;

    @JsonProperty("khuyenmai")
    private Long khuyenmai;

}
