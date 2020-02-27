package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UserWeb002StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserWeb002StartApplication.class,args);
    }

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
