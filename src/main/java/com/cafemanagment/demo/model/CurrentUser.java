package com.cafemanagment.demo.model;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {
    private UserEntity user;

    public CurrentUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public UserEntity getUserEntity() {
        return user;
    }

    public long getUserId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
}
