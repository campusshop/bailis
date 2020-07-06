package com.bailis.qa.service;

import com.bailis.qa.dao.ProblemDao;
import com.bailis.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author zhulang
 * @Classname ProblemService
 * @Description TODO
 * @Date 2020/7/6 14:55
 */
@Service
public class ProblemService {
    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部问题
     *
     * @return Problems
     */
    public List<Problem> findAll() {
        return problemDao.findAll();
    }

    /**
     * 根据ID查询问题
     *
     * @return Problem
     */
    public Problem findById(String id) {
        return problemDao.findById(id).get();
    }

    /**
     * 增加问题
     *
     * @param problem
     */
    public void add(Problem problem) {
        //设置ID
        problem.setId(idWorker.nextId() + "");
        problemDao.save(problem);
    }

    /**
     * 修改问题
     *
     * @param problem
     */
    public void update(Problem problem) {
        problemDao.save(problem);
    }

    /**
     * 删除问题
     *
     * @param id
     */
    public void deleteById(String id) {
        problemDao.deleteById(id);
    }

    /**
     * 查询最新回答列表
     *
     * @param labelId 标签id
     * @param page    页面
     * @param size    条数
     * @return page
     */
    public Page<Problem> findNewListByLabelId(String labelId, int page, int size) {
        Pageable of = PageRequest.of(page - 1, size);
        return problemDao.findNewListByLabelId(labelId, of);
    }

    /**
     * 查询热门回答列表
     *
     * @param labelId 标签id
     * @param page    页面
     * @param size    条数
     * @return page
     */
    public Page<Problem> findHotListByLabelId(String labelId, int page, int size) {
        Pageable of = PageRequest.of(page - 1, size);
        return problemDao.findHotListByLabelId(labelId, of);
    }

    /**
     * 查询等待回答列表
     *
     * @param labelId 标签id
     * @param page    页面
     * @param size    条数
     * @return page
     */
    public Page<Problem> findWaitListByLabelId(String labelId, int page, int size) {
        Pageable of = PageRequest.of(page - 1, size);
        return problemDao.findWaitListByLabelId(labelId, of);
    }

}
