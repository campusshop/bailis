package com.bailis.article.dao;

import com.bailis.article.pojo.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhulang
 * @Classname ChannelDao
 * @Description 文章
 * @Date 2020/7/6 17:29
 */
public interface ChannelDao extends JpaRepository<Channel, String>, JpaSpecificationExecutor<Channel> {
}
