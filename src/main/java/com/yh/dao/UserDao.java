package com.yh.dao;

import com.yh.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> findAllUser();
    User findById(@Param("id") Integer id);
    int updateUser(User user);
}
