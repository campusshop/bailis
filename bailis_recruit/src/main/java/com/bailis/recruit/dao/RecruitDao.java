package com.bailis.recruit.dao;

import com.bailis.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhulang
 * @Classname RecruitDao
 * @Description TODO
 * @Date 2020/7/6 9:03
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {
}
