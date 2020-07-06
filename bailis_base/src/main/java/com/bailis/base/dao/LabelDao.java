package com.bailis.base.dao;

import com.bailis.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhulang
 * @Classname LabelDao 标签数据访问接口
 * @Description TODO
 * @Date 2020/7/5 11:44
 */
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
