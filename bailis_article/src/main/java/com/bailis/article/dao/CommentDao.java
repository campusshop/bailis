package com.bailis.article.dao;

import com.bailis.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author zhulang
 * @Classname CommentDao
 * @Description 评论dao
 * @Date 2020/7/14 9:23
 */
public interface CommentDao extends MongoRepository<Comment, String> {
    /**
     * 根据文章ID查询评论列表
     *
     * @param articleid 文章id
     * @return
     */
    public List<Comment> findByArticleid(String articleid);
}
