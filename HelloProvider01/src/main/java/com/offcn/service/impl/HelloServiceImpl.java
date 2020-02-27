package com.offcn.service.impl;

import com.offcn.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name+":welcome youjiuye!";
    }
}
