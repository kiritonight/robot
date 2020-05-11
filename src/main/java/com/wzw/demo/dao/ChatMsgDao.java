package com.wzw.demo.dao;

import com.wzw.demo.entity.ChatMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 17:282020/5/9/009
 * @Modified By:
 */
@Repository
public interface ChatMsgDao extends JpaRepository<ChatMsg,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM chat_msg ORDER BY id DESC LIMIT 1")
     public ChatMsg findFirst();
}
