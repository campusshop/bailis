package com.bailis.recruit.dao;

import com.bailis.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author zhulang
 * @Classname RecruitDao
 * @Description TODO
 * @Date 2020/7/6 9:03
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {
    /**
     * 查询最新职位表：即按照日期降序排序
     *
     * @param state 0：关闭 1:开启 2：推荐
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 最新职位列表
     *查询状态不为0，并以时间降序排序
     * @param state 0：关闭 1:开启 2：推荐
     * @return
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
