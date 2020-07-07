package com.bailis.article.service;

import com.bailis.article.dao.ChannelDao;
import com.bailis.article.pojo.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

/**
 * @author zhulang
 * @Classname ChannelService
 * @Description 频道
 * @Date 2020/7/6 17:30
 */
@Service
@Transactional
public class ChannelService {
    @Autowired
    private ChannelDao channelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部频道
     *
     * @return Channels
     */
    public List<Channel> findAll() {
        return channelDao.findAll();
    }

    /**
     * 根据ID查询频道
     *
     * @return Channel
     */
    public Channel findById(String id) {
        return channelDao.findById(id).get();
    }

    /**
     * 增加频道
     *
     * @param channel
     */
    public void add(Channel channel) {
        //设置ID
        channel.setId(idWorker.nextId() + "");
        channelDao.save(channel);
    }

    /**
     * 修改频道
     *
     * @param channel
     */
    public void update(Channel channel) {
        channelDao.save(channel);
    }

    /**
     * 删除频道
     *
     * @param id
     */
    public void deleteById(String id) {
        channelDao.deleteById(id);
    }
}
