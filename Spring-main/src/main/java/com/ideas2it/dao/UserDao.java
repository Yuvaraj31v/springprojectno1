package com.ideas2it.dao;


import org.springframework.stereotype.Component;
import com.ideas2it.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.ListIterator;

@Component
public interface UserDao {

    void register(User user);

    List<User> getEmployees();

    User getEmpById(String username);

    void update(User user);




}
