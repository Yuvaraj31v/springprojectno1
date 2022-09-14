package com.ideas2it;

import org.springframework.stereotype.Component;

@Component
public class Manager implements IEmployee{
    public void play() {
        System.out.println("Iam the manager");
    }
}
