package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by reed on 2017/4/20.
 */
@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    @Qualifier("mysqldb")
    private UserDao userDao;

    @Override
    public User getUserByWork_id(String work_id) {
        return this.userDao.getUserByWork_id(work_id);
    }

    @Override
    public void insertUser(User user) {
        this.userDao.insertUserToDb(user);
    }

    @Override
    public void removeUser(String work_id) {
        this.userDao.removeUserByWork_id(work_id);
    }

    @Override
    public void updateUser(String work_id) {
        this.userDao.updateUser(work_id);
    }
}
