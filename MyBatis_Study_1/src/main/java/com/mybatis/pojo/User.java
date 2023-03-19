package com.mybatis.pojo;

/*
 *@Time：2023/3/13
 *@Author：Jelly
 */
public class User {

    private Integer user_id;

    private String user_name;

    private String user_pwd;

    public User(Integer user_ud, String user_name, String user_pwd) {
        this.user_id = user_ud;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }

    public User() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_ud) {
        this.user_id = user_ud;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }
}
