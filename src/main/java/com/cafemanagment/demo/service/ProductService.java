package com.cafemanagment.demo.service;

import com.cafemanagment.demo.model.ProductEntity;

import java.util.List;

public interface ProductService {

    public void add(ProductEntity productEntity);

    public List<ProductEntity> getAll();
}
