package com.wzw.demo.controller;

import com.wzw.demo.entity.User;
import com.wzw.demo.service.UserServiceImp;
import com.wzw.demo.token.TokenService;
import com.wzw.demo.token.UserLoginToken;
import com.wzw.demo.util.RegexUtil;
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

    public static RegexUtil regexutil=new RegexUtil();

    //登陆
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public Map<String, Object> userLogin(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String, Object> map = new HashMap<>(4);
        Boolean flag = false;
        User user = usi.findUserByUsername(username);
        if (user == null) {
            map.put("status", flag);
            map.put("message", "用户不存在");
            return map;
        }
        if (!password.equals(user.getPassword())) {
            map.put("status", flag);
            map.put("message", "密码不正确");
            return map;
        } else {
            flag = true;
            String token = tokenService.getToken(user);
            map.put("token", token);
            map.put("status", flag);
            map.put("message", "登陆成功");
            map.put("user", user);
            return map;
        }
    }

    @RequestMapping(value = "/user/regist", method = RequestMethod.POST)
    public Map<String, Object> userRegist(HttpServletRequest request) {
        String username = request.getParameter("username");
        String realname = request.getParameter("realname");
        String password = request.getParameter("password");
        String checkword = request.getParameter("checkword");
        Map<String, Object> map = new HashMap<>(2);
        if (!password.equals(checkword)) {
            map.put("status", false);
            map.put("message", "密码不一致");
            return map;
        }
        //确保用户不重名。
        if (usi.findUserByUsername(username) == null) {
            Boolean flag = usi.InsertUser(username, realname, password);
            if (flag) {
                map.put("status", true);
                map.put("message", "注册成功");
                return map;
            } else {
                map.put("status", false);
                map.put("message", "注册失败，请重试！");
                return map;
            }
        }
        map.put("status", false);
        map.put("message", "用户名重复");
        return map;
    }

    @UserLoginToken
    @RequestMapping(value = "/user/loginout", method = RequestMethod.POST)
    public Boolean userLoginOut(HttpSession session) {

        try {
            System.out.println("用户已登出");
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @UserLoginToken
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Map<String, Object> userUpdate(HttpServletRequest request) {
        String type = request.getParameter("type");
        String content = request.getParameter("content");
        int id = Integer.parseInt(request.getParameter("id"));
        Map<String, Object> map = new HashMap<>(2);
        map.put("status", false);
        User user = usi.findUserById(id);
        if ("realname".equals(type)) {
            user.setRealname(content);
        } else if ("phone".equals(type)) {
            if (regexutil.regexPhone(content)) {
                user.setPhone(content);
            } else {
                map.put("msg", "手机号格式有问题");
                return map;
            }
        } else if ("email".equals(type)) {
            if (regexutil.regexEmail(content)) {
                user.setEmail(content);
            } else {
                map.put("msg", "邮箱格式有问题");
                return map;
            }
        }
        Boolean flag = usi.InsertUser(user);
        if (flag) {
            map.put("msg", "更改成功");
            map.put("status",true);
            return map;
        } else {
            map.put("msg", "更改失败");
        }
        return map;
    }
}
