package com.ideas2it;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public Employee employee() {
        return new Employee( new Trainee());
    }
    @Bean
    public Trainee trainee() {
        return new Trainee();
    }




}



