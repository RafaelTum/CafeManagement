package com.cafemanagment.demo.repository;

import com.cafemanagment.demo.model.OrderEntity;
import com.cafemanagment.demo.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByTableId(long tableId);

    List<OrderEntity> findByStatus(OrderStatus orderStatus);
}
