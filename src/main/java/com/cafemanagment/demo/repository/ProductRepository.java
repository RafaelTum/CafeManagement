package com.cafemanagment.demo.repository;

import com.cafemanagment.demo.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
