package com.java.banhang.service.impl;


import com.java.banhang.dto.PageResponse;
import com.java.banhang.dto.ProductDTO;
import com.java.banhang.entity.ProductEntity;
import com.java.banhang.repository.ProductRepository;
import com.java.banhang.service.ProductSercive;
import com.java.banhang.util.Converter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductSerciveImpl implements ProductSercive {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Converter converter;

    @Value("${upload.path}")
    private String pathFolder;

    @Override
    public PageResponse<ProductDTO> findAll(int page , int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<ProductEntity> content = productRepository.findAll(pageable);

        List<ProductDTO> ListDTO = new ArrayList<>();
        for (ProductEntity entity: content.getContent()) {
            ListDTO.add(converter.toDTO(entity));
        }
      return new PageResponse<>(ListDTO, content.getTotalPages(), content.getTotalElements(), content.getNumber(), content.getSize());
    }


    @Override
    public PageResponse<ProductDTO> findAllByTensanphamContaining(String tensanpham, int page , int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<ProductEntity> content = productRepository.findAllByTensanphamContaining(tensanpham,pageable);
        List<ProductDTO> ListDTO = new ArrayList<>();
        for (ProductEntity entity: content.getContent()) {
            ListDTO.add(converter.toDTO(entity));
        }
        return new PageResponse<>(ListDTO, content.getTotalPages(), content.getTotalElements(), content.getNumber(), content.getSize());
    }


    @Override
    public Optional<ProductDTO> findById(int id) {
        ProductEntity ProductEntity = productRepository.findById(id).get();
        ProductDTO ProductDTO = converter.toDTO(ProductEntity);

        return Optional.ofNullable(ProductDTO);
    }



    @Override
    public ProductDTO save(ProductDTO productDTO) throws IOException {

        MultipartFile file = productDTO.getImage();
        String fileName = file.getOriginalFilename();

        ProductEntity productEntity = new ProductEntity();
        productEntity.setImage(fileName);
        productRepository.save(converter.toEntity(productDTO));
        productDTO.setId(productEntity.getId());



        if (!fileName.isEmpty()) {
            File uploadRootDir = new File(pathFolder);
            if (!uploadRootDir.exists()) {
                uploadRootDir.mkdirs();                }

            String filename = pathFolder +fileName;
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filename);
            Files.write(path, bytes);
        }

        return productDTO;
    }

    @Override
    public void deleteList(List<String> ids) {
        for (String id : ids) {
            productRepository.deleteById(Integer.valueOf(id));
        }
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public Resource getImage(String filename) throws MalformedURLException {
        Path paths = Paths.get(pathFolder).resolve(filename);
        Resource resource = new UrlResource(paths.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        }
        return resource;
    }
}
