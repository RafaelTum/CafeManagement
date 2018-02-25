package com.cafemanagment.demo.service.serviceImpl;

import com.cafemanagment.demo.model.TableEntity;
import com.cafemanagment.demo.repository.TableRepository;
import com.cafemanagment.demo.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TableRepository tableRepository;

    @Override
    public void add(TableEntity tableEntity) {
        tableRepository.save(tableEntity);
    }

    @Override
    public void deleteById(long id) {
        tableRepository.delete(id);
    }

    @Override
    public List<TableEntity> getAll() {
        return tableRepository.findAll();
    }

    @Override
    public List<TableEntity> getTablesByUserId(long userId) {
        return tableRepository.findAllByUserId(userId);
    }

    @Override
    public TableEntity getById(long id) {
        return tableRepository.findOne(id);
    }

    public void updateTable(TableEntity tableEntity){
        tableRepository.updateTable(tableEntity.getUser(), tableEntity.getId());
    }
}
