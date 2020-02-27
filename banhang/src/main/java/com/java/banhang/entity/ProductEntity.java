package com.java.banhang.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tensanpham")
    private String tensanpham;

    @Column(name = "gia")
    private String gia;

    @Column(name = "giamgia")
    private Long giamgia;

    @Column(name = "khuyenmai")
    private Long khuyenmai;

    @Column(name = "ngaydang")
    @CreationTimestamp
    private Timestamp ngaydang;

    @Column(name = "ngaycapnhat")
    @LastModifiedDate
    private Date ngaycapnhat;
}
