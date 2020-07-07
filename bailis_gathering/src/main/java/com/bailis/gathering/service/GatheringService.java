package com.bailis.gathering.service;

import com.bailis.gathering.dao.GatheringDao;
import com.bailis.gathering.pojo.Gathering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhulang
 * @Classname GatheringService
 * @Description TODO
 * @Date 2020/7/5 11:49
 */
@Service
@Transactional
public class GatheringService {
    @Autowired
    private GatheringDao gatheringDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部活动
     *
     * @return Gatherings
     */
    public List<Gathering> findAll() {
        return gatheringDao.findAll();
    }

    /**
     * 根据ID查询活动
     *
     * @return Gathering
     */
    @Cacheable(value = "gathering",key="#id")
    public Gathering findById(String id) {
        return gatheringDao.findById(id).get();
    }

    /**
     * 增加活动
     *
     * @param gathering
     */
    public void add(Gathering gathering) {
        //设置ID
        gathering.setId(idWorker.nextId() + "");
        gatheringDao.save(gathering);
    }

    /**
     * 修改活动
     *
     * @param gathering
     */
    @CacheEvict(value="gathering",key="#gathering.id")
    public void update(Gathering gathering) {
        gatheringDao.save(gathering);
    }

    /**
     * 删除活动
     *
     * @param id
     */
    @CacheEvict(value="gathering",key="#id")
    public void deleteById(String id) {
        gatheringDao.deleteById(id);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Specification<Gathering> createSpecification(Map searchMap) {
        return new Specification<Gathering>() {
            @Override
            public Predicate toPredicate(Root<Gathering> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if (searchMap.get("name") != null &&
                        !"".equals(searchMap.get("name"))) {
                    predicateList.add(cb.like(root.get("name").as(String.class), "%" + (String) searchMap.get("name") + "%"));
                }
                if (null != searchMap.get("starttime")){
                    predicateList.add(cb.lessThanOrEqualTo(root.get("starttime").as(Date.class), (Date)searchMap.get("starttime")));
                }
                if (null != searchMap.get("endtime")){
                    predicateList.add(cb.greaterThanOrEqualTo(root.get("endtime").as(Date.class), (Date)searchMap.get("endtime")));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }


    /**
     * 条件查询
     *
     * @param searchMap
     * @return
     */

    public List<Gathering> findSearch(Map searchMap) {
        Specification specification = createSpecification(searchMap);
        return gatheringDao.findAll(specification);
    }

    /**
     * 分页条件查询
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public Page<Gathering> findSearch(Map searchMap, int page, int size) {
        Specification specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return gatheringDao.findAll(specification, pageRequest);
    }
}
