package com.example.service;

import org.springframework.stereotype.Component;

@Component // Tells Spring to automatically create a bean named "emailProvider"
public class EmailProvider {
    public void send(String message){
        System.out.println("Message dispatched via pure Annotation Config: "+ message);
    }
}
