package com.wzw.demo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author ZhiWeng Wang
 * @Description:聊天室消息类
 * @Date: Created in 17:172020/5/9/009
 * @Modified By:
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ChatMsg {
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;

    @Column(nullable = false)
    private String msg;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int accountid;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "ChatMsg{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", type='" + type + '\'' +
                ", accountid=" + accountid +
                ", createtime=" + createtime +
                '}';
    }
}
