package com.offcn.service;

import com.offcn.po.User;

import java.util.List;

public interface UserService {

    public void add(User user);
    public void update(User user);
    public void delete(Long id);
    public User findOne(Long id);

    public List<User> findAll();
}
