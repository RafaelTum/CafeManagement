package com.cafemanagment.demo.service.serviceImpl;

import com.cafemanagment.demo.model.ProductInOrderEntity;
import com.cafemanagment.demo.repository.ProductInOrderRepository;
import com.cafemanagment.demo.service.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @Override
    public void add(ProductInOrderEntity productInOrderEntity) {
        productInOrderRepository.save(productInOrderEntity);
    }

    @Override
    public void deleteById(long id) {
        productInOrderRepository.delete(id);
    }

    @Override
    public ProductInOrderEntity getById(long id) {
        return productInOrderRepository.findOne(id);
    }

    @Override
    public List<ProductInOrderEntity> getByOrderId(long id) {
        return productInOrderRepository.findByOrderId(id);
    }
}
