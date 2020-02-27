package com.offcn.service.impl;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    private String findService(){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("USERPROVIDER");
        if(serviceInstanceList!=null&&serviceInstanceList.size()>0){
            ServiceInstance serviceInstance = serviceInstanceList.get(0);
            //获取服务地址
            String host = serviceInstance.getHost();
            //获取端口号
            int port = serviceInstance.getPort();
            return "http://"+host+":"+port;
        }
        return null;
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
