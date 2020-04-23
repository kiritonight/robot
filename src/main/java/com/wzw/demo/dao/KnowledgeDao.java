package com.wzw.demo.dao;

import com.wzw.demo.entity.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 11:242020/4/22/022
 * @Modified By:
 */
@Repository
public interface KnowledgeDao extends JpaRepository<Knowledge,Integer> {

     //当jpa的自带功能无法满足时，使用nativeQuery，原生sql语句
     @Query(nativeQuery = true,value = "SELECT question FROM knowledge WHERE question like :question ORDER BY id desc LIMIT 5")
     List<String> findByQuestionLike(@Param("question") String question);

     @Query(nativeQuery = true,value = "SELECT answer FROM knowledge WHERE question =:question LIMIT 1")
     String findAnswerByQuestion(@Param("question") String question);

     @Query(nativeQuery = true,value = "select question FROM knowledge ORDER BY RAND() LIMIT 3")
     List<String> findQuestionByRand();
}
