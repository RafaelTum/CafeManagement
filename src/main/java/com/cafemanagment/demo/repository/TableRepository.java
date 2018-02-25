package com.cafemanagment.demo.repository;

import com.cafemanagment.demo.model.TableEntity;
import com.cafemanagment.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TableRepository extends JpaRepository<TableEntity, Long> {

    @Modifying
    @Transactional
    @Query("update TableEntity table set table.user=:qUser where table.id=:qId")
    public void updateTable(@Param("qUser") UserEntity userEntity, @Param("qId") Long id);

    List<TableEntity> findAllByUserId(long userId);
}
