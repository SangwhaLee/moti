package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BabystepsApplication {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path","/api");
        SpringApplication.run(BabystepsApplication.class, args);
    }

}
