package com.wzw.demo.service;

import com.wzw.demo.entity.SupportStaff;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 16:002020/5/6/006
 * @Modified By:
 */
public interface SupportStaffService {
    Boolean InsertStaff(String staffname, String realname, String password, String phone);
    SupportStaff findStaffByName(String staffname);
    SupportStaff findStaffById(int id);
}
