package com.yh.service;

import com.github.pagehelper.PageInfo;
import com.yh.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void transfer(Integer sourceId,Integer targetId,Integer money);

    PageInfo<User> findUserByPage(Integer pageIndex, Integer pageSize);
}
