package com.wzw.demo.service;

import com.wzw.demo.dao.ChatMsgDao;
import com.wzw.demo.entity.ChatMsg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 17:372020/5/9/009
 * @Modified By:
 */
@Service
public class ChatMsgServiceImp implements ChatMsgService {
    @Resource
    ChatMsgDao cmd;
    @Override
    public Boolean insertMsg(String type, String msg, int id) {
        ChatMsg chatMsg=new ChatMsg();
        chatMsg.setType(type);
        chatMsg.setMsg(msg);
        chatMsg.setAccountid(id);
        chatMsg.setCreatetime(new Date());
        try{
            cmd.save(chatMsg);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public ChatMsg findFirst() {
        return cmd.findFirst();
    }
}
