package com.bailis.recruit.service;

import com.bailis.recruit.dao.EnterpriseDao;
import com.bailis.recruit.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhulang
 * @Classname EnterpriseService
 * @Description TODO
 * @Date 2020/7/6 10:33
 */
@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseDao enterpriseDao;

    /**
     * @param ishot 是否热门
     * @return
     */
    public List<Enterprise> hotList(String ishot) {
        return enterpriseDao.findByIshot(ishot);
    }
}
