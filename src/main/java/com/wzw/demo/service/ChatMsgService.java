package com.wzw.demo.service;

import com.wzw.demo.entity.ChatMsg;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 17:332020/5/9/009
 * @Modified By:
 */
public interface ChatMsgService {
    public Boolean insertMsg(String type,String msg,int id);
    public ChatMsg findFirst();
}
