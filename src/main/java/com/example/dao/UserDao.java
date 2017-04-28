package com.example.dao;

import com.example.domain.User;

/**
 * Created by reed on 2017/4/18.
 */
public interface UserDao {
    User getUserByWork_id(String work_id);
    void removeUserByWork_id(String work_id);
    void updateUser(String work_id);
    void insertUserToDb(User user);
}
