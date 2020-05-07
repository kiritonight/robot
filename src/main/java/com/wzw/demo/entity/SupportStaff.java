package com.wzw.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 11:022020/4/29/029
 * @Modified By:
 */
@Entity
public class SupportStaff {
    //表示主键
    @Id
    //表示主键生成策略为自动增长
    @GeneratedValue(strategy=AUTO)
    private  int id;

    @Column(nullable = false, unique = true)
    @NotNull
    private String staffname;

    @NotNull
    private String realname;

    @NotNull
    private String password;

    @NotNull
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
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

    @Override
    public String toString() {
        return "SupportStaff{" +
                "id=" + id +
                ", staffname='" + staffname + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
