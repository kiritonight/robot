package com.wzw.demo.service;

import com.wzw.demo.entity.Problem;
import com.wzw.demo.entity.SupportStaff;

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

    List<Object> findProblemAndStaffById(int id);

    Problem findProblemById(int id);

    Boolean updateProblem(Problem problem, SupportStaff staff,String Content);
}
