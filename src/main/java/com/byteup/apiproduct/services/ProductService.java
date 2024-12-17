package com.byteup.apiproduct.services;

import com.byteup.apiproduct.entities.dtos.ProductRecordDto;
import com.byteup.apiproduct.exceptions.ProductNotFoundException;
import com.byteup.apiproduct.entities.ProductEntity;
import com.byteup.apiproduct.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@Service
@EnableCaching
public class ProductService {

    @Autowired
    public ProductRepository productRepository;


    @Cacheable(value = "products",  key = "#id")
    public ProductEntity getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    @CacheEvict(value = "products", key = "#products.id")
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

 //   docker run --name my-redis -p 6379:6379 -d redis
}
