package com.cafemanagment.demo.repository;

import com.cafemanagment.demo.model.Role;
import com.cafemanagment.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

    List<UserEntity> findAllByRole(Role role);

    UserEntity findByUsername(String username);

    UserEntity findByName(String name);
}
