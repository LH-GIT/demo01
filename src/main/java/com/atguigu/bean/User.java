package com.atguigu.bean;
/*************************************************
                时间: 2020-12-30
                作者: 刘  辉
                描述: 
  ************************************************/
public class User {
    private String username;
    private String password;
    private Integer age;
    private boolean gender;

    public User() {
    }

    public User(String username, String password, Integer age, boolean gender) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
