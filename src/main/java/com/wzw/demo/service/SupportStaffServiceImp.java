package com.wzw.demo.service;

import com.wzw.demo.dao.SupportStaffDao;
import com.wzw.demo.entity.SupportStaff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 16:012020/5/6/006
 * @Modified By:
 */
@Service
public class SupportStaffServiceImp implements SupportStaffService {
   @Resource
    SupportStaffDao sd;
    public Boolean InsertStaff(String staffname, String realname, String password, String phone)
    {
        SupportStaff supportStaff=new SupportStaff();
        supportStaff.setStaffname(staffname);
        supportStaff.setRealname(realname);
        supportStaff.setPassword(password);
        supportStaff.setPhone(phone);
        try{
            sd.save(supportStaff);
        }catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public Boolean InsertStaff(SupportStaff staff){
        try{
            sd.save(staff);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public SupportStaff findStaffByName(String staffname) {
        return sd.findSupportStaffByStaffname(staffname);
    }

    @Override
    public SupportStaff findStaffById(int id) {
        return sd.findSupportStaffById(id);
    }
}
