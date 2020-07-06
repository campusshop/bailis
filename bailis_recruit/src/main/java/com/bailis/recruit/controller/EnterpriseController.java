package com.bailis.recruit.controller;

import com.bailis.recruit.service.EnterpriseService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhulang
 * @Classname EnterpriseController
 * @Description TODO
 * @Date 2020/7/6 10:37
 */
@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 查询热门企业
     *
     * @return
     */
    @GetMapping(value = "/search/hotlist")
    public Result hotList() {
        return new Result(true, StatusCode.OK, "查询成功",
                enterpriseService.hotList("1"));
    }
}
