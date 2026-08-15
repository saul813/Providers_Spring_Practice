package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example") // Tells Spring to search inside com.example for @Component
@EnableAspectJAutoProxy // Activates Spring's AOP underlying Engine
public class AppConfig {

}
