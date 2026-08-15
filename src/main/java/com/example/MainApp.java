package com.example;

import com.example.config.AppConfig;
import com.example.service.DatabaseConnectionMock;
import com.example.service.TokenGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //Initilize the container using our configuration blueprint
       ConfigurableApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("--- Testing Scopes ---");
        TokenGenerator t1 = container.getBean(TokenGenerator.class);
        TokenGenerator t2 = container.getBean(TokenGenerator.class);
        t1.printid();
        t2.printid(); // Notice that the IDs are completely different!

        System.out.println("--- Testing AOP Interception ---");
        DatabaseConnectionMock db = container.getBean(DatabaseConnectionMock.class);
        db.executeQuery(); // Our performance aspect will wrap around this execution

        System.out.println("--- Closing Container ---");
        container.close(); // Triggers the @PreDestroy method execution

    }
}
