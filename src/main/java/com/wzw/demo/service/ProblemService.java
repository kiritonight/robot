package com.wzw.demo.service;

import com.wzw.demo.entity.Problem;

import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 10:382020/4/27/027
 * @Modified By:
 */
public interface ProblemService {

    Boolean InsertProblem(String tags,String problemcontent,int userid);

    List<Object> findAllProblem();

    List<Object> findProblemById(int id);
}
