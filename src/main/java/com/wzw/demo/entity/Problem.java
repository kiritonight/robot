package com.wzw.demo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author ZhiWeng Wang
 * @Description:在线回答问题类
 * @Date: Created in 9:502020/4/27/027
 * @Modified By:
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Problem {
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;

    @Column(nullable = false)
    private String  tags;

    @Column(nullable = false, unique = true)
    private String problemcontent;

    @Column(nullable = false)
    private int userid;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createtime;

    private String response;

    private int serviceid;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date responsetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getProblemcontent() {
        return problemcontent;
    }

    public void setProblemcontent(String problemcontent) {
        this.problemcontent = problemcontent;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getServiceid() {
        return serviceid;
    }

    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
    }

    public Date getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(Date responsetime) {
        this.responsetime = responsetime;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", tags='" + tags + '\'' +
                ", problemcontent='" + problemcontent + '\'' +
                ", userid=" + userid +
                ", createtime=" + createtime +
                ", response='" + response + '\'' +
                ", serviceid=" + serviceid +
                ", responsetime=" + responsetime +
                '}';
    }
}
