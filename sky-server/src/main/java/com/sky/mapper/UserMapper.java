package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    // 根据openid来查询用户
    @Select("select * from user where user.openid = #{openid}")
    public User getByOpenid(String openid);

    // 自动完成注册
    void insert(User user);
}
