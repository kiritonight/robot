package com.wzw.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 11:162020/4/22/022
 * @Modified By:
 */
//知识库类，存储系统所需知识
@Entity
public class Knowledge {

    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String question;

    @NotNull
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Knowledge{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
