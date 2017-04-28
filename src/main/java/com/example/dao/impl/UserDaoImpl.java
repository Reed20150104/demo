package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by reed on 2017/4/20.
 */
@Repository
@Qualifier("mysqldb")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public User getUserByWork_id(String work_id) {
        String sqlstr= "SELECT id,username,password,telephone_number,mail"
                +" FROM user where work_id = ?";
        final User user = new User();
        jdbcTemplate.query(sqlstr, new Object[]{work_id},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setId(rs.getInt("id"));
                        user.setWork_id(work_id);
                        user.setPassword(rs.getString("password"));
                        user.setUsername(rs.getString("username"));
                        user.setTelephone_number(rs.getString("telephone_number"));
                        user.setMail(rs.getString("mail"));
                    }
                });
        return user;
    }

    @Override
    public void removeUserByWork_id(String work_id) {
        String sql = "delete from user where work_id = ?";
    }

    @Override
    public void updateUser(String work_id) {

    }

    @Override
    public void insertUserToDb(User user) {
        String sql="insert into user(mail,password,telephone_number,username,work_id)"
                +" values(?,?,?,?,?)";
        Object userArgs[] = {user.getMail(),user.getPassword(),user.getTelephone_number(),
                user.getUsername(),user.getWork_id()};
        jdbcTemplate.update(sql,userArgs);
    }
}
