package com.example.service;

import com.example.domain.User;

/**
 * Created by reed on 2017/4/18.
 */
public interface UserManager {
    public User getUserByWork_id(String work_id);
    public void insertUser(User user);
    public void removeUser(String work_id);
    public void updateUser(String work_id);
}
