package com.byteup.apiproduct.services;

import com.byteup.apiproduct.entities.dtos.ProductRecordDto;
import com.byteup.apiproduct.exceptions.ProductNotFoundException;
import com.byteup.apiproduct.entities.ProductEntity;
import com.byteup.apiproduct.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public ProductEntity getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    public ProductEntity updateProduct(Long id, ProductRecordDto productRecordDto) {
        ProductEntity productModel = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
        BeanUtils.copyProperties(productRecordDto, productModel);
        return productRepository.save(productModel);
    }

    public ProductEntity saveProduct(ProductRecordDto productRecordDto) {
        ProductEntity productModel = new ProductEntity();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return productRepository.save(productModel);
    }
}
