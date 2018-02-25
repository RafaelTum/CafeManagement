package com.cafemanagment.demo.service;

import com.cafemanagment.demo.model.TableEntity;
import com.cafemanagment.demo.model.UserEntity;

import java.util.List;

public interface TableService {

    public void add(TableEntity tableEntity);

    public void deleteById(long id);

    public List<TableEntity> getAll();

    public List<TableEntity> getTablesByUserId(long userId);

    public TableEntity getById(long id);

    public void updateTable(TableEntity tableEntity);

}
