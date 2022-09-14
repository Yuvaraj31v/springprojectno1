package com.ideas2it;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    Employee(){

    }
    @Autowired
    private Trainer trainer;

    private  Trainee trainee;

    @Autowired
    private IEmployee employee;

    public Employee(Trainee trainee) {
        this.trainee=trainee;
    }

    public void callTrainer() {
        trainer.add();
        trainee.train();
        employee.play();
    }


}

