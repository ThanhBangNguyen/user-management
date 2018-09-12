package com.usermanagement.demo.services;

import com.usermanagement.demo.dao.models.User;

public interface UserService {
    String addUser(User user);
    void postUser(User user);
}
