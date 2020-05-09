package com.wzw.demo.dao;

import com.wzw.demo.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 10:362020/4/27/027
 * @Modified By:
 */
@Repository
public interface ProblemDao extends JpaRepository<Problem,Integer> {

    //查找所有的问题
    @Query(value = "SELECT p.id,p.tags,p.problemcontent,p.createtime,u.username FROM problem p INNER JOIN user u ON p.userid=u.id ORDER BY createtime DESC",nativeQuery = true)
     List<Object> findAllProblem();

    //查找单个问题的详细信息
    @Query(value = "SELECT p.tags,p.problemcontent,p.createtime,p.response,p.responsetime,u.username,s.staffname,p.id FROM problem p INNER JOIN user u ON p.userid=u.id LEFT JOIN support_staff s ON p.serviceid=s.id WHERE p.id=:id",nativeQuery = true)
    List<Object> findProblemAndStaffById(@Param("id") int problemid);

    Problem findProblemById(int id);
}
