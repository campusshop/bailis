package com.bailis.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhulang
 * @Classname Label
 * @Description TODO
 * @Date 2020/7/5 11:30
 */
@Entity
@Table(name = "tb_label")
@Data
public class Label {
    @Id
    private String id;
    /**
     * 标签名称
     */
    private String labelname;
    /**
     * 状态
     */
    private String state;
    /**
     * 使用数量
     */
    private Long count;
    /**
     * 关注数
     */
    private Long fans;
    /**
     * 是否推荐
     */
    private String recommend;

}
