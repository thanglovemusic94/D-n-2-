package com.java.banhang.api;

import com.java.banhang.dto.PageResponse;
import com.java.banhang.dto.ProductDTO;
import com.java.banhang.entity.ProductEntity;
import com.java.banhang.service.ProductSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductApi {

    @Autowired
    private ProductSercive productSercive;

    @GetMapping
    public PageResponse<ProductDTO> getAll(@RequestParam(value = "page", defaultValue = "1") int page,
                                              @RequestParam(value = "size", defaultValue = "10") int size) {
        return productSercive.findAll(page, size);
    }

    @GetMapping("/search_name")
    public PageResponse<ProductDTO> getAllByTenSanPham(
            @RequestParam(value = "tensanpham") String tensanpham,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return productSercive.findAllByTensanphamContaining(tensanpham,page,size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public ProductDTO save(@RequestBody ProductDTO dto) throws IOException {
        return productSercive.save(dto);
    }


    @GetMapping("/{id}")
    public Optional<ProductDTO> findById(@PathVariable("id") Integer id) {
        System.out.println("hehe");
        return productSercive.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ProductDTO update(@PathVariable("id") Integer id, @RequestBody ProductDTO dto) throws IOException {
        Optional<ProductDTO> productDTO = Optional.ofNullable(productSercive.findById(id).get());
        if (!productDTO.isPresent()) {
            System.out.println(" id  khong tồn tại");
        }
        System.out.println(" id :" + id);
        productDTO.get().setTensanpham(dto.getTensanpham());
        productDTO.get().setImage(dto.getImage());
        productDTO.get().setGia(dto.getGia());
        productDTO.get().setGiamgia(dto.getGiamgia());
        productDTO.get().setKhuyenmai(dto.getKhuyenmai());

        return productSercive.save(productDTO.get());
    }

    @DeleteMapping("/{ids}")
    public void remove(@PathVariable("ids") List<String> ids) {
        productSercive.deleteList(ids);
    }

    @DeleteMapping
    public void removeAll() {
        productSercive.deleteAll();
    }

    @GetMapping("/images/{filename}")
    @ResponseBody
    public Resource getImage(@PathVariable String  filename) throws IOException {
        return productSercive.getImage(filename);
    }

}
