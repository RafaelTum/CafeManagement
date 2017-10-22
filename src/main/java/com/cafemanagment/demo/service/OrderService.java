package com.cafemanagment.demo.service;

import com.cafemanagment.demo.model.OrderEntity;
import com.cafemanagment.demo.model.OrderStatus;

import java.util.List;


public interface OrderService {

    public void add(OrderEntity orderEntity);

    public void deleteById(long id);

    public OrderEntity getById(long id);

    public List<OrderEntity> getByTableId(long tableId);

    public List<OrderEntity> getAll();

    public List<OrderEntity> getAllByStatus(OrderStatus orderStatus);
}
