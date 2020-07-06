package com.bailis.qa.dao;

import com.bailis.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author zhulang
 * @Classname ProblemDao
 * @Description 问题dao
 * @Date 2020/7/6 14:54
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {
    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * from tb_problem tp JOIN tb_pl tpl ON tp.id=tpl.problemid AND tpl.labelid=?1 ORDER BY tp.replytime DESC", nativeQuery = true)
    public Page<Problem> findNewListByLabelId(String labelId, Pageable pageable);

    /**
     * 根据标签ID查询热门问题列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * from tb_problem tp JOIN tb_pl tpl ON tp.id=tpl.problemid AND tpl.labelid=?1 ORDER BY tp.reply DESC", nativeQuery = true)
    public Page<Problem> findHotListByLabelId(String labelId, Pageable pageable);

    /**
     * 根据标签ID查询等待回答列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * from tb_problem tp JOIN tb_pl tpl ON tp.id=tpl.problemid AND tpl.labelid=?1  and tp.reply=0 ORDER BY tp.createtime DESC", nativeQuery = true)
    public Page<Problem> findWaitListByLabelId(String labelId, Pageable pageable);
}
