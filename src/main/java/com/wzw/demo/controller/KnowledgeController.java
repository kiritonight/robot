package com.wzw.demo.controller;

import com.wzw.demo.entity.Knowledge;
import com.wzw.demo.service.KnowledgeServiceImp;
import com.wzw.demo.token.UserLoginToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 11:352020/4/22/022
 * @Modified By:
 */
@RestController
public class KnowledgeController {

    @Resource
    private KnowledgeServiceImp ksi;
    @UserLoginToken
    @RequestMapping(value = "/knowledge/find",method = RequestMethod.POST)
    public Map<String,Object> findQuestionLike(HttpServletRequest request)
    {
        String question=request.getParameter("question");
        Map<String,Object> map=new HashMap<>(2);
        List<String> qlist=ksi.findByQuestionLike("%"+question+"%");
        if(qlist.isEmpty())
        {
            map.put("type",0);
           return map;
        }
        map.put("questionList",qlist);
        map.put("type",2);
        return map;
    }
    @UserLoginToken
    @RequestMapping(value = "/knowledge/get",method = RequestMethod.POST)
    public Map<String,Object> getAnswerByQuestion(HttpServletRequest request)
    {
        String question=request.getParameter("question");
        Map<String,Object> map=new HashMap<>(2);
        String answer=ksi.findAnswerByQuestion(question);
        if(null==answer)
        {
            map.put("status",false);
            return map;
        }else {
            map.put("status",true);
            map.put("answer",answer);
            return map;
        }
    }
    @UserLoginToken
    @RequestMapping(value = "/knowledge/rand",method = RequestMethod.POST)
    public  Map<String,Object> getQuestionByRand(HttpServletRequest request)
    {
        Map<String,Object> map=new HashMap<>(1);
        List<String> rlist=ksi.findQuestionByRand();
        map.put("questionList",rlist);
        return map;
    }
}
