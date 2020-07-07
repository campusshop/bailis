package com.bailis.gathering.dao;

import com.bailis.gathering.pojo.Gathering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhulang
 * @Classname GatheringDao
 * @Description 活动dao
 * @Date 2020/7/7 21:54
 */
public interface GatheringDao extends JpaRepository<Gathering, String>, JpaSpecificationExecutor<Gathering> {
}
