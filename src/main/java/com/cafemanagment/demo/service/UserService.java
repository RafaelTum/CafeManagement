package com.cafemanagment.demo.service;

import com.cafemanagment.demo.model.UserEntity;

import java.util.List;

public interface UserService {

    public void add(UserEntity userEntity);

    public void deleteUserById(long id);

    public UserEntity getById(long id);

    public List<UserEntity> getAll();

    public List<UserEntity> getWaiters();

    public UserEntity getUserByUsername(String username);

    public UserEntity getUserByName(String name);

}
