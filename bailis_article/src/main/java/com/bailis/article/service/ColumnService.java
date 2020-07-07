package com.bailis.article.service;

import com.bailis.article.dao.ColumnDao;
import com.bailis.article.pojo.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

/**
 * @author zhulang
 * @Classname ColumnService
 * @Description 专栏
 * @Date 2020/7/6 17:30
 */
@Service
@Transactional
public class ColumnService {
    @Autowired
    private ColumnDao columnDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部专栏
     *
     * @return Columns
     */
    public List<Column> findAll() {
        return columnDao.findAll();
    }

    /**
     * 根据ID查询专栏
     *
     * @return Column
     */
    public Column findById(String id) {
        return columnDao.findById(id).get();
    }

    /**
     * 增加专栏
     *
     * @param column
     */
    public void add(Column column) {
        //设置ID
        column.setId(idWorker.nextId() + "");
        columnDao.save(column);
    }

    /**
     * 修改专栏
     *
     * @param column
     */
    public void update(Column column) {
        columnDao.save(column);
    }

    /**
     * 删除专栏
     *
     * @param id
     */
    public void deleteById(String id) {
        columnDao.deleteById(id);
    }
}
