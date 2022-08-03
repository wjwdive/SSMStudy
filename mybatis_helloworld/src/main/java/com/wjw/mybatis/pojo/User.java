package com.wjw.mybatis.pojo;


//核心配置文件，映射文件

public class User {
    private Integer id;

    private String username;

    private String password;

    private String gender;

    private Integer age;

    private String email;

    //必须要有
    public User() {

    }

    public User(Integer id, String username, String password, String gender, Integer age, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
