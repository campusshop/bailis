package com.bailis.article.controller;

import com.bailis.article.pojo.Comment;
import com.bailis.article.service.CommentService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhulang
 * @Classname CommentController
 * @Description TODO
 * @Date 2020/7/14 9:40
 */
@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 新增评论
     *
     * @param comment 评论
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Comment comment) {
        commentService.add(comment);
        return new Result(true, StatusCode.OK, "提交成功 ");
    }

    /**
     * 根据文章id查询文章列表
     *
     * @param articleid 文章id
     * @return
     */
    @GetMapping(value = "/article/{articleid}")
    public Result findByArticleid(@PathVariable String articleid) {
        return new Result(true, StatusCode.OK, "查询成功", commentService.findByArticleid(articleid));
    }
}
