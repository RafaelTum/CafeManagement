package com.cafemanagment.demo.repository;

import com.cafemanagment.demo.model.ProductInOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrderEntity, Long> {

    List<ProductInOrderEntity> findByOrderId(long id);

}
