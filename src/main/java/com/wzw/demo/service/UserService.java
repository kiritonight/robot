package com.wzw.demo.service;

import com.wzw.demo.entity.User;

import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 15:512020/4/21/021
 * @Modified By:
 */
public interface UserService {

    User findUserByUsername(String username);

    Boolean InsertUser(String username,String realname,String password);

    Boolean InsertUser(User user);

    User findUserById(int id);


}
