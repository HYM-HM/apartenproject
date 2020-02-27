package com.offcn.controller;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/")
    public String add(@RequestBody User user){
        service.add(user);
        return "add-success";
    }
    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,@RequestBody User user){
        user.setId(id);
        service.update(user);

        return "update-success";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "delete-success";
    }
    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long id){
        return service.findOne(id);
    }
    @GetMapping("/")
    public Map findAll(){
        Map map=new HashMap();
        List<User> list = service.findAll();
        map.put("list",list);
        map.put("version","UserProvider01");
       /* int sleep = new Random().nextInt(1000);
        System.out.println("服务1，休息:"+sleep);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return map;
    }
}
