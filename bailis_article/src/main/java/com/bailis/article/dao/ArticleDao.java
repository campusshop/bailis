package com.bailis.article.dao;

import com.bailis.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author zhulang
 * @Classname ArticleDao
 * @Description 文章
 * @Date 2020/7/6 17:29
 */
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {
    /**
     * 审核
     *
     * @param id
     */
    @Modifying
    @Query(value = "update tb_article ta SET ta.state='1' WHERE ta.id=?1", nativeQuery = true)
    void examine(String id);

    /**
     * 点赞更新
     *
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update tb_article ta SET ta.thumbup=ta.thumbup+1 WHERE ta.id=?1", nativeQuery = true)
    void updateThumbup(String id);
}
