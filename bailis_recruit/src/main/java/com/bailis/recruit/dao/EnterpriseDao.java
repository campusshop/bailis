package com.bailis.recruit.dao;

import com.bailis.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author zhulang
 */
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {
    /**
     * 查询热门企业
     *
     * @param ishot
     * @return
     */
    public List<Enterprise> findByIshot(String ishot);
}