package com.bailis.qa.service;

import com.bailis.qa.dao.ReplyDao;
import com.bailis.qa.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author zhulang
 * @Classname ReplyService
 * @Description TODO
 * @Date 2020/7/6 14:55
 */
@Service
public class ReplyService {
    @Autowired
    private ReplyDao replyDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部问题
     *
     * @return Replys
     */
    public List<Reply> findAll() {
        return replyDao.findAll();
    }

    /**
     * 根据ID查询问题
     *
     * @return Reply
     */
    public Reply findById(String id) {
        return replyDao.findById(id).get();
    }

    /**
     * 增加问题
     *
     * @param reply
     */
    public void add(Reply reply) {
        //设置ID
        reply.setId(idWorker.nextId() + "");
        replyDao.save(reply);
    }

    /**
     * 修改问题
     *
     * @param reply
     */
    public void update(Reply reply) {
        replyDao.save(reply);
    }

    /**
     * 删除问题
     *
     * @param id
     */
    public void deleteById(String id) {
        replyDao.deleteById(id);
    }

}
