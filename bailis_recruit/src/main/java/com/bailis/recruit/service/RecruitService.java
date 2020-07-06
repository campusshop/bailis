package com.bailis.recruit.service;

import com.bailis.recruit.dao.RecruitDao;
import com.bailis.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author zhulang
 * @Classname RecruitService
 * @Description TODO
 * @Date 2020/7/6 9:02
 */
@Service
public class RecruitService {
    @Autowired
    private RecruitDao recruitDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部招聘岗位
     *
     * @return Recruits
     */
    public List<Recruit> findAll() {
        return recruitDao.findAll();
    }

    /**
     * 根据id查询招聘岗位
     *
     * @param id
     * @return
     */
    public Recruit findOne(String id) {
        return recruitDao.findById(id).get();
    }

    /**
     * 新增招聘岗位
     *
     * @param recruit
     */
    public void add(Recruit recruit) {
        recruit.setId(idWorker.nextId() + "");
        recruitDao.save(recruit);
    }

    /**
     * 更新招聘岗位
     *
     * @param recruit
     */
    public void update(Recruit recruit) {
        recruitDao.save(recruit);
    }

    /**
     * 根据id删除岗位
     *
     * @param id
     */
    public void delete(String id) {
        recruitDao.deleteById(id);
    }
}
