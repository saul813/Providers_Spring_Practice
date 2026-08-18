package com.example;

import com.example.config.DataConfig;
import com.example.service.WarehouseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(DataConfig.class);
        WarehouseService warehouse = container.getBean(WarehouseService.class);

        try {
            System.out.println("Initiating transactional inventory deployment block...");
            warehouse.setupInventoryBatch();
        } catch (Exception e) {
            System.err.println("Caught deliberate application crash context: " + e.getMessage());
            System.out.println("Success: Check your database tables. Because of @Transactional, the database remains completely empty!");
        }
    }
}
