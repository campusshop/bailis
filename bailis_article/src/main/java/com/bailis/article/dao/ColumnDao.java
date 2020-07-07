package com.bailis.article.dao;

import com.bailis.article.pojo.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhulang
 * @Classname ColumnDao
 * @Description 文章
 * @Date 2020/7/6 17:29
 */
public interface ColumnDao extends JpaRepository<Column, String>, JpaSpecificationExecutor<Column> {
}
