package com.wzw.demo.service;

import com.wzw.demo.dao.ProblemDao;
import com.wzw.demo.entity.Problem;
import com.wzw.demo.entity.SupportStaff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 10:392020/4/27/027
 * @Modified By:
 */
@Service
public class ProblemServiceImp implements ProblemService{
    @Resource
    ProblemDao pd;

    @Override
    public Boolean InsertProblem(String tags, String problemcontent, int userid)
    {
        Problem problem=new Problem();
        problem.setTags(tags);
        problem.setProblemcontent(problemcontent);
        problem.setUserid(userid);
        problem.setCreatetime(new Date());
        try{
            pd.save(problem);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Object> findAllProblem() {
        return pd.findAllProblem();
    }

    @Override
    public List<Object> findProblemAndStaffById(int id) {
        return pd.findProblemAndStaffById(id);
    }

    @Override
    public Problem findProblemById(int id) {
        return pd.findProblemById(id);
    }

    @Override
    public Boolean updateProblem(Problem problem, SupportStaff staff, String Content) {
        problem.setResponsetime(new Date());
        problem.setResponse(Content);
        problem.setServiceid(staff.getId());
        try{
            pd.save(problem);
        }catch (Exception e){
            return false;
        }
        return true;
}


}
