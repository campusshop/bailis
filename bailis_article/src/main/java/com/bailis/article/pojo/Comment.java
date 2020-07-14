package com.bailis.article.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhulang
 * @Classname Comment
 * @Description 文章评论（mongoDB）
 * @Date 2020/7/14 8:45
 */
@Data
public class Comment implements Serializable {
    @Id
    private String _id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;
}
