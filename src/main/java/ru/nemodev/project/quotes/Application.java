package ru.nemodev.project.quotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import ru.nemodev.project.quotes.config.spring.ApplicationConfig;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackageClasses = {ApplicationConfig.class})
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}

