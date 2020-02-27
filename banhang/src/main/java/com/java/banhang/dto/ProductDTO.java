package com.java.banhang.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("tensanpham_ahihi")
    private String tensanpham;

    @JsonProperty("gia")
    private String gia;

    @JsonProperty("giamgia")
    private Long giamgia;

    @JsonProperty("khuyenmai")
    private Long khuyenmai;

    @JsonProperty("ngaydang")
    private Timestamp ngaydang;

    @JsonProperty("ngaycapnhat")
    private Timestamp ngaycapnhat;
}
