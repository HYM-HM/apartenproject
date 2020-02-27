package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer02StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer02StartApplication.class,args);
    }
}
