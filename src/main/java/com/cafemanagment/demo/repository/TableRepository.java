package com.cafemanagment.demo.repository;

import com.cafemanagment.demo.model.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<TableEntity, Long> {

    List<TableEntity> findAllByWaiterId(long waiterId);
}
