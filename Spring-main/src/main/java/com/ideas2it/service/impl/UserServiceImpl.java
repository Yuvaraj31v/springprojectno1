package com.ideas2it.service.impl;

import com.ideas2it.dao.UserDao;
import com.ideas2it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ideas2it.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public void register(User user) {
        userDao.register(user);
    }

    public List<User> getEmployees() {
        return userDao.getEmployees();
    }

    public  List<User> getEmployeeById(String username) {
        List<User> list = new ArrayList<User>();
        list.add(userDao.getEmpById(username));
        return list;
    }

    public void update(User user){
        userDao.update(user);
    }
}