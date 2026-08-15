package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionMock {

    @PostConstruct //Runs automatically right after the bean is fully constructed
    public void connect() {
        System.out.println("Lifecycle: Opening database connection pool...");
    }

    public void executeQuery() {
        System.out.println("Query executed successfully.");
    }

    @PreDestroy //Runs automatically right before the Spring container shuts down
    public void disconnect() {
        System.out.println("Lifecycle: Safely closing database connection pool...");
    }

}
