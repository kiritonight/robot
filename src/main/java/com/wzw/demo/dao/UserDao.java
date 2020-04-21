package com.wzw.demo.dao;

import com.wzw.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 15:382020/4/21/021
 * @Modified By:
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findUserByUsername(String username);


}
