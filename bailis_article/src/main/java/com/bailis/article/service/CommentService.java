package com.bailis.article.service;

import com.bailis.article.dao.CommentDao;
import com.bailis.article.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author zhulang
 * @Classname CommentService
 * @Description 评论业务层
 * @Date 2020/7/14 9:35
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private IdWorker idWorker;

    public void add(Comment comment) {
        comment.set_id(idWorker.nextId() + "");
        commentDao.save(comment);
    }

    /**
     * 查询评论列表
     *
     * @param articleid 文章id
     * @return
     */
    public List<Comment> findByArticleid(String articleid) {
        return commentDao.findByArticleid(articleid);
    }
}
