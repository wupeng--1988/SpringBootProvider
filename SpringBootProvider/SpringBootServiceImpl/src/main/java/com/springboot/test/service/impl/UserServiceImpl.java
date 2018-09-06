package com.springboot.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.test.dao.UserMapper;
import com.springboot.test.dao.UserMapperTest;
import com.springboot.test.pojo.User;
import com.springboot.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

//    @Resource
//    private UserMapper userMapper;
    @Autowired
    private UserMapperTest userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User selectByUP(String username, String password) {
        return userMapper.selectByLogin(username,password);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> insertUser(User user) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("status",userMapper.insertSelective(user));
        return map;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> deleteUserByPK(int id) {
        Map<String ,Object> map = new HashMap<String,Object>();
        map.put("status",userMapper.deleteByPrimaryKey(id));
        return map;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public PageInfo selectAll(int index) {
        PageHelper.startPage(index,8);
        List<User> users = userMapper.selectAll();
        PageInfo pageInfo = new PageInfo(users);
        return pageInfo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Map<String, Object> updatePSD(String username, String password) {
        Map<String ,Object> map = new HashMap<String,Object>();
        userMapper.updatePSD(password,username);
        map.put("status",1);
        return map;
    }


}
