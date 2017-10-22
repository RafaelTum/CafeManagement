package com.cafemanagment.demo.service.serviceImpl;


import com.cafemanagment.demo.model.CurrentUser;
import com.cafemanagment.demo.model.UserEntity;
import com.cafemanagment.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.getUserByUsername(username);
        if (userEntity == null){
            throw new UsernameNotFoundException(String.format("User with email=%s was not found", username));
        }
        return new CurrentUser(userEntity);
    }
}
