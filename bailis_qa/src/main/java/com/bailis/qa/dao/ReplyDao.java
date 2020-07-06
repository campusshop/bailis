package com.bailis.qa.dao;

import com.bailis.qa.pojo.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhulang
 * @Classname ReplyDao
 * @Description 回复dao
 * @Date 2020/7/6 14:54
 */
public interface ReplyDao extends JpaRepository<Reply, String>, JpaSpecificationExecutor<Reply> {
}
