package com.cafemanagment.demo.service.serviceImpl;

import com.cafemanagment.demo.model.ProductEntity;
import com.cafemanagment.demo.repository.ProductInOrderRepository;
import com.cafemanagment.demo.repository.ProductRepository;
import com.cafemanagment.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void add(ProductEntity productEntity) {
        productRepository.save(productEntity);

    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }
}
