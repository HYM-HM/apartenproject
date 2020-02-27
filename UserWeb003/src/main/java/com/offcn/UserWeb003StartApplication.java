package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UserWeb003StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserWeb003StartApplication.class,args);
    }

    @Bean
    @LoadBalanced   //ribbon提供的负载均衡
    public RestTemplate createRestTemplate(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(250);
        factory.setConnectTimeout(250);
        return new RestTemplate(factory);
    }
}
