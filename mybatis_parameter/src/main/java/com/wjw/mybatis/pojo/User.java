package com.wjw.mybatis.pojo;


//核心配置文件，映射文件

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private String gender;


    private String email;

    //必须要有
    public User() {

    }

    public User(Integer id, String username, String password, Integer age, String gender , String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    //属性，成员变量和属性不一样，属性时getter，setter函数名去除get,后面部分大写变小写的部分。成员变量是上面定义的 id; 这里属性和成员变量一致是因为使用了IDEA模板创建的。
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
