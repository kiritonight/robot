package com.wzw.demo.controller;

import com.wzw.demo.entity.User;
import com.wzw.demo.service.UserServiceImp;
import com.wzw.demo.token.TokenService;
import com.wzw.demo.token.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 15:562020/4/21/021
 * @Modified By:
 */
@RestController
public class UserController {

    @Resource
       private UserServiceImp usi;
    @Autowired
    TokenService tokenService;
     //登陆
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
     public Map<String, Object> userLogin(HttpServletRequest request, HttpSession session) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Map<String,Object> map=new HashMap<>(4);
        Boolean flag=false;
        User user=usi.findUserByUsername(username);
        if(user==null)
        {
          map.put("status",flag);
          map.put("message","用户不存在");
          return map;
        }
        if(!password.equals(user.getPassword()))
        {
          map.put("status",flag);
          map.put("message","密码不正确");
          return map;
        }
        else {
            flag = true;
            String token=tokenService.getToken(user);
            map.put("token",token);
            map.put("status", flag);
            map.put("message", "登陆成功");
            map.put("user", user);
            return map;
        }
    }
    @RequestMapping(value = "/user/regist",method = RequestMethod.POST)
    public Map<String,Object> userRegist(HttpServletRequest request){
        String username=request.getParameter("username");
        String realname=request.getParameter("realname");
        String password=request.getParameter("password");
        String checkword=request.getParameter("checkword");
        Map<String,Object> map=new HashMap<>(2);
        if(!password.equals(checkword)) {
            map.put("status",false);
            map.put("message","密码不一致");
            return map;
        }
        //确保用户不重名。
        if(usi.findUserByUsername(username)==null) {
            Boolean flag=usi.InsertUser(username,realname,password);
            if(flag){
                map.put("status",true);
                map.put("message","注册成功");
                return map;
            } else{
                map.put("status",false);
                map.put("message","注册失败，请重试！");
                return map;
            }
        }
        map.put("status",false);
        map.put("message","用户名重复");
        return map;
    }
    @UserLoginToken
    @RequestMapping(value = "/user/loginout",method = RequestMethod.POST)
    public Boolean userLoginOut(HttpSession session) {

        try {
            System.out.println("你已通过验证");
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
