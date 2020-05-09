package com.wzw.demo.controller;

import com.wzw.demo.entity.Problem;
import com.wzw.demo.entity.SupportStaff;
import com.wzw.demo.service.ProblemServiceImp;
import com.wzw.demo.service.SupportStaffServiceImp;
import com.wzw.demo.token.UserLoginToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 10:572020/4/27/027
 * @Modified By:
 */
@RestController
public class ProblemController {
    @Resource
    private ProblemServiceImp psi;
    @Resource
    SupportStaffServiceImp sssi;


    private String[] tagsarray={"抗疫","5G","流量","充值","宽带","生活"};

    @UserLoginToken
    @RequestMapping(value = "/problem/add",method = RequestMethod.POST)
    public Map<String,Object> addProblem(HttpServletRequest request) {
        String tags=tagsarray[Integer.parseInt(request.getParameter("tags"))];
        String problemcontent=request.getParameter("content");
        int userid=Integer.parseInt(request.getParameter("userid"));
        Boolean flag=psi.InsertProblem(tags,problemcontent,userid);
        Map<String, Object> map = new HashMap<>(1);
        if(flag) {
            map.put("status",true);
            return map;
        }else {
            map.put("status",false);
            return map;
        }
    }

    @RequestMapping(value = "/problem/index",method = RequestMethod.POST)
    public Map<String,Object> findAllProblem(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(1);
        List<Object> problemList=psi.findAllProblem();
        map.put("problemlist",problemList);
        return map;
    }

    @RequestMapping(value = "/problem/get",method = RequestMethod.POST)
    public List<Object> findProblemById(HttpServletRequest request) {
        int id=Integer.parseInt(request.getParameter("id"));
        Map<String, Object> map = new HashMap<>(1);
        List<Object> list=psi.findProblemAndStaffById(id);
        return list;
    }

    @RequestMapping(value = "/problem/update",method = RequestMethod.POST)
    public Boolean updateProblem(HttpServletRequest request) {
        String content=request.getParameter("content");
        int staffid=Integer.parseInt(request.getParameter("staffid"));
        int problemid=Integer.parseInt(request.getParameter("problemid"));
        SupportStaff staff=sssi.findStaffById(staffid);
        Problem problem=psi.findProblemById(problemid);
        Boolean flag=psi.updateProblem(problem,staff,content);
        if(flag){
            return true;
        }else {
            return false;
        }
    }
}
