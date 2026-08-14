package com.example;

import com.example.config.AppConfig;
import com.example.service.NotificationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //Initilize the container using our configuration blueprint
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        //Fetch the automatically registered bean from the container
        NotificationService service = container.getBean(NotificationService.class);

        service.alertUser("Annotation based setup completed");
    }
}
