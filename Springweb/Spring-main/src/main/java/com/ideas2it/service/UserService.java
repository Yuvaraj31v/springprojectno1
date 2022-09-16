package com.ideas2it.service;


import com.ideas2it.model.User;

import org.springframework.stereotype.Component;

import java.util.List;


public interface UserService {
    void register(User user);

    List<User> getEmployees();

    List<User> getEmployeeById(String username);

    void update(User user);




}
