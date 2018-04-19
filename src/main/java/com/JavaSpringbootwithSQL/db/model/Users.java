package com.JavaSpringbootwithSQL.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer UserId;
    @Column(name = "UserName")
    private String Username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "nickName")
    private String nickName;




    public Users(int userId, String username, String password,String email,String nickName) {
    }

    public Integer getId() {
        return UserId;
    }

    public void setId(Integer id) {
        this.UserId = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String name) {
        this.Username = name;
    }

    public String getpassword() {
        return Username;
    }

    public void setpassword(String name) {
        this.Username = name;
    }

}
