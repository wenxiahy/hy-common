package com.wenxiahy.hy.common.bean.entity;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-12-17
 */
public class User {

    private long userId;

    private String username;

    private String password;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}
