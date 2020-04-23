package com.wzw.demo.service;

import com.wzw.demo.entity.Knowledge;

import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 11:312020/4/22/022
 * @Modified By:
 */
public interface KnowledgeService {
    List<String> findByQuestionLike(String question);

    String findAnswerByQuestion(String question);

    List<String> findQuestionByRand();
}
