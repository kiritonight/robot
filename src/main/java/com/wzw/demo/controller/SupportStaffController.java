package com.wzw.demo.controller;

import com.wzw.demo.entity.SupportStaff;
import com.wzw.demo.service.SupportStaffServiceImp;
import com.wzw.demo.token.TokenService;
import com.wzw.demo.util.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 16:082020/5/6/006
 * @Modified By:
 */
@RestController
public class SupportStaffController {
    @Resource
    SupportStaffServiceImp sssi;

    @Autowired
    TokenService tokenService;

    public static RegexUtil regexutil=new RegexUtil();

    //客服注册
    @RequestMapping(value = "/staff/regist",method = RequestMethod.POST)
    public Map<String,Object> staffRegist(HttpServletRequest request) {
        String staffname = request.getParameter("staffname");
        String realname = request.getParameter("realname");
        String password = request.getParameter("password");
        String checkword = request.getParameter("checkword");
        String phone=request.getParameter("phone");
        Map<String, Object> map = new HashMap<>(2);
        if (!password.equals(checkword)) {
            map.put("status", false);
            map.put("message", "密码不一致");
            return map;
        }
        if (!regexutil.regexPhone(phone)){
            map.put("status", false);
            map.put("message", "手机号格式错误");
            return map;
        }
        if(sssi.findStaffByName(staffname)==null){
            Boolean flag = sssi.InsertStaff(staffname,realname,password,phone);
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
        map.put("message", "客服名重复");
        return map;
    }
    //客服登陆
    @RequestMapping(value = "/staff/login",method = RequestMethod.POST)
    public Map<String,Object> staffLogin(HttpServletRequest request) {
        String staffname = request.getParameter("staffname");
        String password = request.getParameter("password");
        Map<String, Object> map = new HashMap<>(4);
        Boolean flag = false;
        SupportStaff supportStaff=sssi.findStaffByName(staffname);
        if (supportStaff == null) {
            map.put("status", flag);
            map.put("message", "客服不存在");
            return map;
        }
        if(!password.equals(supportStaff.getPassword())) {
            map.put("status", flag);
            map.put("message", "密码不正确");
            return map;
        } else{
            flag = true;
            map.put("status", flag);
            map.put("message", "登陆成功");
            map.put("supportStaff",supportStaff);
            return map;
        }
    }

    @RequestMapping(value = "/staff/update",method = RequestMethod.POST)
    public Map<String,Object> updateStaff(HttpServletRequest request)
    {
        String content=request.getParameter("content");
        int id=Integer.parseInt(request.getParameter("id"));
        Map<String,Object> map=new HashMap<>(2);
        SupportStaff staff=sssi.findStaffById(id);
        if (regexutil.regexPhone(content)) {
            staff.setPhone(content);
        }else{
            map.put("status",false);
            map.put("msg","手机号格式有问题");
            return map;
        }
        Boolean flag=sssi.InsertStaff(staff);
        if(flag){
            map.put("status",true);
            map.put("msg", "更改成功");
        }else{
            map.put("status",false);
            map.put("msg","更改失败");
        }
        return map;
    }
}
