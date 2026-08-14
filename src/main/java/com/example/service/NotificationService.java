package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Tells spring to automatically create a bean named "notificationService"
public class NotificationService {
    private final   EmailProvider emailProvider;

    @Autowired // Tells Spring to automatically find the EmailProvider bean and inject it here
    public NotificationService(EmailProvider emailProvider) {
        this.emailProvider = emailProvider;
    }

    public void alertUser(String text){
        emailProvider.send(text);
    }
}
