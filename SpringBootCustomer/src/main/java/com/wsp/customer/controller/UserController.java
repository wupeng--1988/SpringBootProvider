package com.wsp.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.springboot.test.pojo.User;
import com.springboot.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("login.do")
    @ResponseBody
    public User login(@RequestParam("phone") String username, @RequestParam("password") String password) {
        return userService.selectByUP(username, password);
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public Map<String, Object> delete(@RequestParam("id") int id) {
        return userService.deleteUserByPK(id);
    }

    @RequestMapping("add.do")
    @ResponseBody
    public Map<String, Object> insert(@ModelAttribute("user") User user) {
        return userService.insertUser(user);
    }

    @RequestMapping("listall.do")
    @ResponseBody
    public Map<String, Object> selectAll(@RequestParam("index") int index) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", userService.selectAll(index));
        return map;
    }

    @RequestMapping("updatepsd.do")
    @ResponseBody
    public Map<String, Object> updatePSD(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", userService.updatePSD(phone, password));
        return map;
    }

}
