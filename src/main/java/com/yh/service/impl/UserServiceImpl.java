package com.yh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.dao.UserDao;
import com.yh.pojo.User;
import com.yh.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAllUser();
    }

    @Override
//    @Transactional(isolation = Isolation.DEFAULT, readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void transfer(Integer sourceId, Integer targetId, Integer money) {

        User sourceUser = userDao.findById(sourceId);
        User targetUser = userDao.findById(targetId);
        sourceUser.setMoney(sourceUser.getMoney() - money);
        targetUser.setMoney(targetUser.getMoney() + money);
        userDao.updateUser(sourceUser);
//        int i = 10 / 0;
        userDao.updateUser(targetUser);
    }

    @Override
    public PageInfo<User> findUserByPage(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<User> allUser = userDao.findAllUser();
        PageInfo<User> pageInfo= new PageInfo<>(allUser);
        return pageInfo;
    }
}
