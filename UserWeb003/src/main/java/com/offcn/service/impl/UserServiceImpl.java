package com.offcn.service.impl;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

   /* @Autowired
    private DiscoveryClient discoveryClient;*/

   /*@Autowired
   private LoadBalancerClient loadBalancerClient;*/
    @Autowired
    private RestTemplate restTemplate;

    private String findService(){

            return "http://USERPROVIDER";

    }

    @Override
    public void add(User user) {
        String response = restTemplate.postForObject(findService() + "/user/", user, String.class);
        System.out.println("添加用户成功");
    }

    @Override
    public void update(User user) {
      restTemplate.put(findService()+"/user/"+user.getId(),user);
        System.out.println("更新用户成功");
    }

    @Override
    public void delete(Long id) {
       restTemplate.delete(findService()+"/user/"+id);
        System.out.println("删除用户成功");
    }

    @Override
    public User findOne(Long id) {
        return restTemplate.getForObject(findService()+"/user/"+id,User.class);
    }

    @Override
    public Map findAll() {
        return restTemplate.getForObject(findService()+"/user/",Map.class);
    }
}
