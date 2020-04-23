package com.wzw.demo.service;

import com.wzw.demo.dao.KnowledgeDao;
import com.wzw.demo.entity.Knowledge;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 11:322020/4/22/022
 * @Modified By:
 */
@Service
public class KnowledgeServiceImp implements KnowledgeService {
    @Resource
    private KnowledgeDao kd;
    @Override
    public List<String> findByQuestionLike(String question) {
        return kd.findByQuestionLike(question);
    }

    @Override
    public String findAnswerByQuestion(String question) {
        return kd.findAnswerByQuestion(question);
    }

    @Override
    public List<String> findQuestionByRand() {
        return kd.findQuestionByRand();
    }

}
