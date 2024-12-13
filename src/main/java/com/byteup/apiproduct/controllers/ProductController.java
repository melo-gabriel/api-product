package com.byteup.apiproduct.controllers;

import com.byteup.apiproduct.entities.ProductEntity;
import com.byteup.apiproduct.entities.dtos.ProductRecordDto;
import com.byteup.apiproduct.exceptions.ProductNotFoundException;
import com.byteup.apiproduct.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        try {
            ProductEntity getProductById = productService.getById(id);
            return ResponseEntity.ok(getProductById);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable(value = "id") Long id, @RequestBody @Validated ProductRecordDto productRecordDto) {
        try {
            ProductEntity updateProduct = productService.updateProduct(id, productRecordDto);
            return ResponseEntity.ok(updateProduct);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody @Validated ProductRecordDto productRecordDto) {
        ProductEntity createdProduct = productService.saveProduct(productRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
}
