package com.ideas2it;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Supervisor implements IEmployee {
    public void play() {
        System.out.println("super vised");
    }
}
