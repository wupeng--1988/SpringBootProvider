package com.springboot.test.dao;

import com.springboot.test.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapperTest {

    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "loginname", property = "loginname"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "password", property = "password"),
            @Result(column = "order_num", property = "orderNum"),
            @Result(column = "nickname", property = "nickname"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "address", property = "address"),
            @Result(column = "status", property = "status"),
            @Result(column = "total", property = "total")
    })

    @Select("SELECT * FROM USER WHERE phone=#{phone} and password=#{password}")
    public User selectByLogin(@Param("phone") String username, @Param("password") String password) ;

    @Insert("INSERT INTO USER(phone,password) VALUES (#{phone},#{password}")
    int insertSelective(User user);

    @Delete("DELETE FROM USER WHERE user_id=#{id}")
    int deleteByPrimaryKey(int id);

    @Select("SELECT * FROM USER")
    List<User> selectAll();

    @Update("UPDATE USER SET password=#{password} WHERE phone=#{phone}")
    int updatePSD(@Param("password")String password,@Param("phone")String phone);
}
