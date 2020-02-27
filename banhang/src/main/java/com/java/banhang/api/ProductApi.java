package com.java.banhang.api;

import com.java.banhang.dto.PageResponse;
import com.java.banhang.dto.ProductDTO;
import com.java.banhang.entity.ProductEntity;
import com.java.banhang.service.ProductSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductApi {

    @Autowired
    private ProductSercive productSercive;

    @GetMapping
    public List<ProductEntity> getAll(@RequestParam(value = "page", defaultValue = "1") int page,
                                              @RequestParam(value = "size", defaultValue = "10") int size) {
        return productSercive.getAll(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO save(@RequestBody ProductDTO dto) {
        return productSercive.save(dto);
    }


    @GetMapping("/{id}")
    public Optional<ProductDTO> findById(@PathVariable Integer id) {
        Optional<ProductDTO> productDTO = Optional.ofNullable(productSercive.findById(id).get());
        return productDTO;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@PathVariable Integer id, @RequestBody ProductDTO dto) {
        Optional<ProductDTO> productDTO = Optional.ofNullable(productSercive.findById(id).get());
        if (!productDTO.isPresent()) {
            System.out.println(" id  khong tồn tại");
        }
        System.out.println(" id :" + id);
        productDTO.get().setTensanpham(dto.getTensanpham());
        productDTO.get().setGia(dto.getGia());
        productDTO.get().setGiamgia(dto.getGiamgia());
        productDTO.get().setKhuyenmai(dto.getKhuyenmai());
        productDTO.get().setNgaycapnhat(dto.getNgaycapnhat());

        return productSercive.save(productDTO.get());
    }

    @DeleteMapping("/{ids}")
    public void remove(@PathVariable List<String> ids) {
        productSercive.deleteAll(ids);
    }

    //    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Integer id) {
//        Optional<ProductDTO> productDTO = Optional.ofNullable(productSercive.findById(id).get());
//
//        if (!productDTO.isPresent()) {
//            System.out.println(" id  khong tồn tại");
//        }
//        productSercive.delete(id);
//    }

}
