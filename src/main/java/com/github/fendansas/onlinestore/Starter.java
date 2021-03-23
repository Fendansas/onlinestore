package com.github.fendansas.onlinestore;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableConfigurationProperties(EmailProperties.class)
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}

