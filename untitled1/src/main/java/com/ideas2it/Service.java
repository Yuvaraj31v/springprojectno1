package com.ideas2it;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
    @Autowired
    private  Dao trainerDao;

    public void add(Employee employee) {
        if (employee instanceof  Trainer) {
            trainerDao.add((Trainer) employee);
        }
        else {
            trainerDao.add((Trainee) employee);
        }
    }

    public void display() {
        trainerDao.display();
    }
}
