package com.ideas2it;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Dao {

    private static List<Trainer> trainerList = new ArrayList<Trainer>();
    private static List<Trainee> traineeList = new ArrayList<Trainee>();

    public void add(Employee employee) {
        if (employee instanceof Trainer){
            trainerList.add((Trainer) employee);
        }
        else {
            traineeList.add((Trainee) employee);
        }
    }

    public void display() {
        System.out.println(traineeList);
        System.out.println(trainerList);

    }

}
