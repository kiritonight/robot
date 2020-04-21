package com.wzw.demo.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 15:152020/4/21/021
 * @Modified By:
 */
//这是一个实体类，自动创建与实体类对应的表。
@Entity
public class User {
    //表示主键
    @Id
    //表示主键生成策略为自动增长
   @GeneratedValue(strategy=AUTO)
   private  int id;

    @Column(nullable = false, unique = true)
    @NotNull
    private String username;
    @NotNull
    private String realname;
    @NotNull
    private String password;

   private String phone;
   @Email
   private String email;

   public User(String username,String realname,String password,String phone,String email){
       this.username=username;
       this.realname=realname;
       this.password=password;
       this.phone=phone;
       this.email=email;
   }

   public User(){

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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
