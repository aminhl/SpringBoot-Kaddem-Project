package com.habngroup.springboot_kaddem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootKaddemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKaddemApplication.class, args);
    }

}
