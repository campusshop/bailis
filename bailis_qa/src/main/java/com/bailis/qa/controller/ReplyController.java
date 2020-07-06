package com.bailis.qa.controller;

import com.bailis.qa.pojo.Reply;
import com.bailis.qa.service.ReplyService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhulang
 * @Classname ReplyController
 * @Description 回复控制类
 * @Date 2020/7/6 15:09
 */
@RestController
@RequestMapping("/reply")
@CrossOrigin
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    /**
     * 查询全部列表
     *
     * @return
     */
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功",
                replyService.findAll());
    }

    /**
     * 根据ID查询回复
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", replyService.findById(id));
    }

    /**
     * 增加回复
     *
     * @param reply
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Reply reply) {
        replyService.add(reply);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改回复
     *
     * @param reply
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Reply reply, @PathVariable String id) {
        reply.setId(id);
        replyService.update(reply);
        return new Result(true, StatusCode.OK, "修改成功");
    }


    /**
     * 删除回复
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable String id) {
        replyService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
