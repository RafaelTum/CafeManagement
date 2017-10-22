package com.cafemanagment.demo.service.serviceImpl;

import com.cafemanagment.demo.model.OrderEntity;
import com.cafemanagment.demo.model.OrderStatus;
import com.cafemanagment.demo.repository.OrderRepository;
import com.cafemanagment.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void add(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
    }

    @Override
    public void deleteById(long id) {
        orderRepository.delete(id);
    }

    @Override
    public OrderEntity getById(long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public List<OrderEntity> getByTableId(long tableId) {
        return orderRepository.findByTableId(tableId);
    }

    @Override
    public List<OrderEntity> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderEntity> getAllByStatus(OrderStatus orderStatus) {
        return orderRepository.findByStatus(orderStatus);
    }
}
