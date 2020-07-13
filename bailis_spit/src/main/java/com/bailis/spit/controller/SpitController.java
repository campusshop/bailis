package com.bailis.spit.controller;

import com.bailis.spit.pojo.Spit;
import com.bailis.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhulang
 * @Classname SpitController
 * @Description 吐槽控制层
 * @Date 2020/7/13 16:19
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {
    @Autowired
    private SpitService spitService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 点赞更新
     *
     * @param id
     * @return
     */
    @PutMapping(value = "/thumbup/{id}")
    public Result updateThumbup(@PathVariable String id) {
//        暂时固定当前登录用户，后面会修改
        String userid = "1013";
        Object obj = redisTemplate.opsForValue().get("thumbup_" + userid + "_" + id);
        if (obj != null) {
//            代表已经点过赞
            return new Result(false, StatusCode.REPERROR, "你已经点过赞啦");
        } else {
            spitService.updateThumbup(id);
            redisTemplate.opsForValue().set("thumbup_" + userid + "_" + id, "1");
            return new Result(true, StatusCode.OK, "点赞成功");
        }
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findAll());
    }

    /**
     * 查询id
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findOne(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findById(id));
    }

    /**
     * 增加
     *
     * @param spit
     */
    @PostMapping
    public Result add(@RequestBody Spit spit) {
        spitService.add(spit);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param spit
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Spit spit, @PathVariable String id) {
        spit.set_id(id);
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "修改成功");
    }


    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable String id) {
        spitService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 根据上级ID查询吐槽分页数据
     *
     * @param parentid 上级id
     * @param page     页码
     * @param size     条数
     * @return
     */
    @GetMapping(value = "/comment/{parentid}/{page}/{size}")
    public Result findByParentid(@PathVariable("parentid") String parentid, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Spit> spitPage = spitService.findByParentid(parentid, page, size);
        PageResult pageResult = new PageResult<Spit>(spitPage.getTotalElements(), spitPage.getContent());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }


}
