package com.JavaSpringbootwithSQL.db.model;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Integer UserId;
    @Column(name = "UserName")
    private String Username;
    @Column(name = "password")
    private String password;
    @Column(name = "nickName")
    private String nickName;


    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Users() {
    }


}
