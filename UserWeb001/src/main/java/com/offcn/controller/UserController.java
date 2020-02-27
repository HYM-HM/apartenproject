package com.offcn.controller;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    //获取列表数据，跳转到列表模板
    @GetMapping("/")
    public String getList(Model model){
        Map map = service.findAll();
        model.addAttribute("list",map.get("list"));
        model.addAttribute("version",map.get("version"));
        return "list";
    }
    //点击add按钮，跳转到新增用户页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    //点击保存按钮，保存新增用户数据
    @PostMapping("/add")
    public String add(User user){
        service.add(user);
        return "redirect:/";
    }

    //跳转到编辑页面
    @GetMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model model){
        User user = service.findOne(id);
        model.addAttribute("user",user);
        return "edit";
    }
    //保存修改数据
    @PostMapping("/update")
    public String update(User user){
        service.update(user);
        return "redirect:/";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/";
    }
}
