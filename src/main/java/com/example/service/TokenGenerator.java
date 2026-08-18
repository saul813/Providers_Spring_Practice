package com.example.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Forces Spring to create a new instance on every request
public class TokenGenerator {
    private final double id = Math.random();

    public void printid(){
        System.out.println("Token Generator Instance ID:" + id);
    }
}
