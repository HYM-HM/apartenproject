package com.offcn.service;

import com.offcn.config.FeignConfig;
import com.offcn.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@FeignClient(value ="USERPROVIDER",configuration = FeignConfig.class)
public interface UserService {
    @PostMapping("/user/")
    public void add(User user);
    @PutMapping("/user/{id}")
    public void update(@PathVariable("id") Long id, User user);
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id")Long id);
    @GetMapping("/user/{id}")
    public User findOne(@PathVariable("id")Long id);

    @GetMapping("/user/")
    public Map findAll();
}
