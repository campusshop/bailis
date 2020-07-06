package com.bailis.recruit.controller;

import com.bailis.recruit.pojo.Recruit;
import com.bailis.recruit.service.RecruitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhulang
 * @Classname RecruitController
 * @Description TODO
 * @Date 2020/7/5 23:23
 */
@RestController
@RequestMapping("/recruit")
@CrossOrigin
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    /**
     * 查询推荐岗位
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        return new Result(true, 2000, "查询成功", recruitService.findAll());
    }

    /**
     * 根据查询推荐岗位
     *
     * @param id
     * @return
     */
    public Result findOne(String id) {
        return new Result(true, 2000, "查询成功", recruitService.findOne(id));
    }

    /**
     * 新增推荐岗位
     *
     * @param recruit
     * @return
     */
    public Result add(Recruit recruit) {
        recruitService.add(recruit);
        return new Result(true, 2000, "添加成功");
    }

    /**
     * 更新成功
     *
     * @param recruit
     * @return
     */
    public Result update(Recruit recruit) {
        recruitService.update(recruit);
        return new Result(true, 2000, "更新成功");
    }

    /**
     * 删除岗位
     *
     * @param id
     * @return
     */
    public Result delete(String id) {
        recruitService.delete(id);
        return new Result(true, 2000, "删除成功");
    }

    /**
     * 查询最新top4岗位(根据时间排序)
     * 2：推荐
     *
     * @return
     */
    @GetMapping(value = "/search/recommend")
    public Result recommend() {
        List<Recruit> list = recruitService.findTop4ByStateOrderByCreatetimeDesc("2");
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 最新职位列表
     * 查询状态不为0，并以时间降序排序
     *
     * @return
     */
    @GetMapping(value = "/search/newlist")
    public Result newlist() {
        return new Result(true, StatusCode.OK, "查询成功", recruitService.newlist());
    }
}
