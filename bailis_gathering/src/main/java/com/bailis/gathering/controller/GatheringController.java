package com.bailis.gathering.controller;

import com.bailis.gathering.pojo.Gathering;
import com.bailis.gathering.service.GatheringService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhulang
 * @Classname GatheringController
 * @Description TODO
 * @Date 2020/7/5 11:57
 */
@RestController
@RequestMapping("/gathering")
@CrossOrigin
public class GatheringController {
    @Autowired
    private GatheringService gatheringService;

    /**
     * 查询全部列表
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功",
                gatheringService.findAll());
    }

    /**
     * 根据ID查询活动
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", gatheringService.findById(id));
    }

    /**
     * 增加活动
     *
     * @param gathering
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Gathering gathering) {
        gatheringService.add(gathering);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改活动
     *
     * @param gathering
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Gathering gathering, @PathVariable String id) {
        gathering.setId(id);
        gatheringService.update(gathering);
        return new Result(true, StatusCode.OK, "修改成功");
    }


    /**
     * 删除活动
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable String id) {
        gatheringService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @PostMapping(value = "/search")
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, StatusCode.OK, "查询成功", gatheringService.findSearch(searchMap));
    }

    /**
     * 条件+分页查询
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page pageList = gatheringService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<>
                (pageList.getTotalElements(), pageList.getContent()));
    }
}
