package com.springboot.test.service;

import com.github.pagehelper.PageInfo;
import com.springboot.test.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User selectByUP(String username,String password);
    public Map<String ,Object> insertUser(User user);
    public Map<String ,Object> deleteUserByPK(int id);
    public PageInfo selectAll(int index);
    public Map<String ,Object> updatePSD(String username,String password);
}
