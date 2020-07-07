package com.bailis.article.service;

import com.bailis.article.dao.ArticleDao;
import com.bailis.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhulang
 * @Classname ArticleService
 * @Description 文章
 * @Date 2020/7/6 17:30
 */
@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据ID查询文章
     *
     * @return Article
     */
    public Article findById(String id) {
        //从缓存中提取
        Article article = (Article) redisTemplate.opsForValue().get("article_" + id);
        // 如果缓存没有则到数据库查询并放入缓存
        if (article == null) {
            article = articleDao.findById(id).get();
            redisTemplate.opsForValue().set("article_" + id, article,1, TimeUnit.DAYS);
        }
        return article;
    }

    /**
     * 查询全部文章
     *
     * @return Articles
     */
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    /**
     * 增加文章
     *
     * @param article
     */
    public void add(Article article) {
        //设置ID
        article.setId(idWorker.nextId() + "");
        articleDao.save(article);
    }

    /**
     * 修改文章
     *
     * @param article
     */
    public void update(Article article) {
        //删除缓存
        redisTemplate.delete("article_" + article.getId());
        articleDao.save(article);
    }

    /**
     * 删除文章
     *
     * @param id
     */
    public void deleteById(String id) {
        //删除缓存
        redisTemplate.delete("article_" + id);
        articleDao.deleteById(id);
    }

    /**
     * 文章审核
     *
     * @param id 文章ID
     */
    public void examine(String id) {
        articleDao.examine(id);
    }

    /**
     * 点赞
     *
     * @param id 文章ID
     * @return
     */
    public void updateThumbup(String id) {
        articleDao.updateThumbup(id);
    }
}
