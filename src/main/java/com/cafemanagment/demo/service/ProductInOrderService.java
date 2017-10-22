package com.cafemanagment.demo.service;

import com.cafemanagment.demo.model.ProductInOrderEntity;

import java.util.List;

public interface ProductInOrderService {

    public void add(ProductInOrderEntity productInOrderEntity);

    public void deleteById(long id);

    public ProductInOrderEntity getById(long id);

    public List<ProductInOrderEntity> getByOrderId(long Id);
}
