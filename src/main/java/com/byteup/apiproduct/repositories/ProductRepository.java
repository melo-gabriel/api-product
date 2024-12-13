package com.byteup.apiproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.byteup.apiproduct.entities.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
