package com.wzw.demo.controller;

import com.wzw.demo.entity.ChatMsg;
import com.wzw.demo.service.ChatMsgServiceImp;
import com.wzw.demo.service.SupportStaffServiceImp;
import com.wzw.demo.service.UserServiceImp;
import com.wzw.demo.token.UserLoginToken;
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
 * @Date: Created in 17:422020/5/9/009
 * @Modified By:
 */
@RestController
public class ChatMsgController {
    @Resource
    private ChatMsgServiceImp cmsi;

    @Resource
    private UserServiceImp usi;

    @Resource
    SupportStaffServiceImp sssi;


    @RequestMapping(value = "/chat/msgadd",method = RequestMethod.POST)
    public Boolean addMsg(HttpServletRequest request) {
        String type=request.getParameter("type");
        String msg=request.getParameter("msg");
        int id=Integer.parseInt(request.getParameter("id"));
        Boolean flag=cmsi.insertMsg(type,msg,id);
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping(value = "/chat/msgget",method = RequestMethod.POST)
    public Map<String,Object> getMsg(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>(5);
        ChatMsg msg=cmsi.findFirst();
        String accountname="";
        if("user".equals(msg.getType())){
            accountname=usi.findUserById(msg.getAccountid()).getUsername();
        }else{
            accountname=sssi.findStaffById(msg.getAccountid()).getStaffname();
        }
        map.put("msg",msg.getMsg());
        map.put("creattime",msg.getCreatetime());
        map.put("name",accountname);
        map.put("type",msg.getType());
        map.put("accountid",msg.getAccountid());
        return map;
    }
}
