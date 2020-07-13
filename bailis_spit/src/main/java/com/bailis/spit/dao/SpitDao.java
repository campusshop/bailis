package com.bailis.spit.dao;

import com.bailis.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author zhulang
 * @Classname SpitDao
 * @Description 吐槽数据访问层
 * @Date 2020/7/13 15:58
 */
public interface SpitDao extends MongoRepository<Spit, String> {
    /**
     * *根据上级ID查询吐槽列表（分页）
     *
     * @param parentid 上级id
     * @param pageable 分页对象
     * @return
     */
    Page<Spit> findByParentid(String parentid, Pageable pageable);
}
