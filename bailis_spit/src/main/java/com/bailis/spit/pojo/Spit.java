package com.bailis.spit.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhulang
 * @Classname Spit 吐槽
 * @Description TODO
 * @Date 2020/7/13 15:32
 */
@Data
public class Spit implements Serializable {
    @Id
    private String _id;
    /**
     * 吐槽内容
     */
    private String content;
    /**
     * 吐槽日期
     */
    private Date publishtime;
    /**
     * 用户id
     */
    private String userid;
    /**
     *用户昵称
     */
    private String nickname;
    /**
     *浏览数
     */
    private Integer visits;
    /**
     *点赞数
     */
    private Integer thumbup;
    /**
     *分享数
     */
    private Integer share;
    /**
     *评论数
     */
    private Integer comment;
    /**
     *状态是否可见
     */
    private String state;
    /**
     *父id
     */
    private String parentid;
}
