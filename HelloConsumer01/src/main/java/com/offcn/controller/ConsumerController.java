package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;  //连接到Eurekaserver查找服务

    @Autowired
    private RestTemplate restTemplate; //spring框架提供的专门用于调用Rest风格接口模板工具类

    @RequestMapping("/demo1")
    public String demo1(String name){
        String response = restTemplate.getForObject(findService() + "/hello?name=" + name, String.class);
        return response;
    }

    //根据应用名称，查找服务地址、端口等相关信息
    private String findService(){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("HELLOPROVIDER");
        //获取第一个服务
        if(instanceList!=null&&instanceList.size()>0) {
            //服务信息封装对象
            ServiceInstance serviceInstance = instanceList.get(0);
            //服务地址
            String host = serviceInstance.getHost();
            //服务端口
            int port = serviceInstance.getPort();
            return "http://"+host+":"+port;
        }

        return null;
    }
}
