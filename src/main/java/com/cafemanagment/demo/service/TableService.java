package com.cafemanagment.demo.service;

import com.cafemanagment.demo.model.TableEntity;

import java.util.List;

public interface TableService {

    public void add(TableEntity tableEntity);

    public void deleteById(long id);

    public List<TableEntity> getAll();

    public List<TableEntity> getTablesByWaiterId(long waiterId);

    public TableEntity getById(long id);

}
