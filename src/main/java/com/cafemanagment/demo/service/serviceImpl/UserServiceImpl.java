package com.cafemanagment.demo.service.serviceImpl;

import com.cafemanagment.demo.model.Role;
import com.cafemanagment.demo.model.UserEntity;
import com.cafemanagment.demo.repository.UserRepository;
import com.cafemanagment.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.delete(id);
    }

    @Override
    public UserEntity getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserEntity> getWaiters() {
        return userRepository.findAllByRole(Role.WAITER);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity getUserByName(String name) {
        return userRepository.findByName(name);
    }
}
