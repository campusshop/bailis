package com.bailis.qa.controller;

import com.bailis.qa.pojo.Problem;
import com.bailis.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhulang
 * @Classname ProblemController
 * @Description 问题控制类
 * @Date 2020/7/6 15:09
 */
@RestController
@RequestMapping("/problem")
@CrossOrigin
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    /**
     * *根据标签ID查询最新问题列表
     *
     * @param labelid 标签id
     * @param page    页码
     * @param size    条数
     * @return Result
     */
    @GetMapping("/newlist/{labelid}/{page}/{size}")
    public Result findNewListByLabelId(@PathVariable("labelid") String labelid, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Problem> problemPage = problemService.findNewListByLabelId(labelid, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Problem>(problemPage.getTotalElements(), problemPage.getContent()));
    }

    /**
     * *根据标签ID查询热门回答列表
     *
     * @param labelid 标签id
     * @param page    页码
     * @param size    条数
     * @return Result
     */
    @GetMapping("/hotlist/{labelid}/{page}/{size}")
    public Result findHotListByLabelId(@PathVariable("labelid") String labelid, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Problem> problemPage = problemService.findHotListByLabelId(labelid, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Problem>(problemPage.getTotalElements(), problemPage.getContent()));
    }

    /**
     * *根据标签ID查询等待回答列表
     *
     * @param labelid 标签id
     * @param page    页码
     * @param size    条数
     * @return Result
     */
    @GetMapping("/waitlist/{labelid}/{page}/{size}")
    public Result findWaitListByLabelId(@PathVariable("labelid") String labelid, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Problem> problemPage = problemService.findWaitListByLabelId(labelid, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Problem>(problemPage.getTotalElements(), problemPage.getContent()));
    }

    /**
     * 查询全部列表
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功",
                problemService.findAll());
    }

    /**
     * 根据ID查询问题
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", problemService.findById(id));
    }

    /**
     * 增加问题
     *
     * @param problem
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Problem problem) {
        problemService.add(problem);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改问题
     *
     * @param problem
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Problem problem, @PathVariable String id) {
        problem.setId(id);
        problemService.update(problem);
        return new Result(true, StatusCode.OK, "修改成功");
    }


    /**
     * 删除问题
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable String id) {
        problemService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
