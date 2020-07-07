package com.bailis.article.controller;

import com.bailis.article.pojo.Article;
import com.bailis.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhulang
 * @Classname ArticleController
 * @Description TODO
 * @Date 2020/7/7 12:16
 */
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 审核
     *
     * @param id
     * @return
     */
    @PutMapping(value = "/examine/{id}")
    public Result examine(@PathVariable String id) {
        articleService.examine(id);
        return new Result(true, StatusCode.OK, "审核成功！");
    }

    /**
     * 点赞
     *
     * @param id
     * @return
     */
    @PutMapping(value = "/thumbup/{id}")
    public Result updateThumbup(@PathVariable String id) {
        articleService.updateThumbup(id);
        return new Result(true, StatusCode.OK, "点赞成功");
    }

    /**
     * 查询文章
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", articleService.findById(id));
    }

    /**
     * 更新文章
     *
     * @param article
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public Result update(@RequestBody Article article, @PathVariable("id") String id) {
        article.setId(id);
        articleService.update(article);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable String id) {
        articleService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
