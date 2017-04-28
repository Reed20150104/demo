package com.example.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by reed on 2017/4/17.
 */
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, nullable = false)
    private String username;
    @Column(length = 30, nullable = false)
    @NotBlank(message = "工号不能为空")
    private String work_id;
    @Column(length = 500, nullable = false)
    @NotBlank(message = "密码不能为空")
    private String password;
    @Column(length = 20)
    private String telephone_number;
    @Column(length = 30)
    private String mail;


    private String password2;

    public User() {}

    public String getWork_id() {
        return work_id;
    }

    public void setWork_id(String work_id) {
        this.work_id = work_id;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", work_id='" + work_id + '\'' +
                ", password='" + password + '\'' +
                ", telephone_number='" + telephone_number + '\'' +
                ", mail='" + mail + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
