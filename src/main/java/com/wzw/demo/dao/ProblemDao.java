package com.wzw.demo.dao;

import com.wzw.demo.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 10:362020/4/27/027
 * @Modified By:
 */
@Repository
public interface ProblemDao extends JpaRepository<Problem,Integer> {


}
