package com.wzw.demo.dao;

import com.wzw.demo.entity.SupportStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 15:582020/5/6/006
 * @Modified By:
 */
@Repository
public interface SupportStaffDao extends JpaRepository<SupportStaff,Integer> {
     SupportStaff findSupportStaffByStaffname(String staffname);

     SupportStaff findSupportStaffById(int id);
}
