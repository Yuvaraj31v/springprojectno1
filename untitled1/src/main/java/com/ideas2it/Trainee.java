package com.ideas2it;

import org.springframework.stereotype.Component;

@Component
public class Trainee extends Employee {
    public void train(){
        System.out.println("Trained");
    }

}
