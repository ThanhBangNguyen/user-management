package com.usermanagement.demo.services;

import com.usermanagement.demo.dao.models.User;
import com.usermanagement.demo.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "oke";
    }

    public void postUser(User user) {
        user.setUsername(user.getUsername());
        user.setFullname(user.getFullname());
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return;
    }
}
