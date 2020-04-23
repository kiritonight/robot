package com.wzw.demo.service;

import com.wzw.demo.dao.UserDao;
import com.wzw.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 15:532020/4/21/021
 * @Modified By:
 */
@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserDao ud;

   /*
     根据用户名查询user
    */
    @Override
    public User findUserByUsername(String username) {

        return ud.findUserByUsername(username);
    }

    @Override
    public Boolean InsertUser(String username, String realname, String password) {
        User user=new User();
        user.setUsername(username);
        user.setRealname(realname);
        user.setPassword(password);
        user.setEmail(null);
        user.setPhone(null);
        try{
            ud.save(user);

        }catch (Exception e)
        {
            return false;
        }
       return true;
    }

    @Override
    public User findUserById(int id) {
        return ud.findUserById(id);
    }


}
