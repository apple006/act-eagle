package com.dayi35.framework.service;

import com.dayi35.framework.dao.BaseDao;
import com.dayi35.framework.page.Page;
import org.beetl.sql.core.DSTransactionManager;

import javax.inject.Inject;
import java.util.List;

/**
 * Service基类,包含基本的CRUD
 * Created by leeton on 9/29/17.
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> baseDao;

    /**
     * Beelsql的事务管理类
     */
    public DSTransactionManager tx = new DSTransactionManager();


    public BaseServiceImpl() {
    }

    @Inject
    public BaseServiceImpl(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public T get(Long id) {
        return baseDao.get(id);
    }

    @Override
    public int save(T t) {
        return baseDao.save(t);
    }

    @Override
    public int update(T t) {
        return baseDao.save(t);
    }

    @Override
    public int delete(T t) {
        return baseDao.delete(t);
    }

    @Override
    public int delete(Long id) {
        return baseDao.delete(id);
    }

    @Override
    public List<T> getList(String frameSql, Object... args) {
        return baseDao.getList(frameSql, args);
    }

    @Override
    public List<T> getList(String sql) {
        return baseDao.getList(sql);
    }

    @Override
    public Page<T> getPage(Page page, String frameSql, Object[] args) {
        return baseDao.getPage(page, frameSql, args);
    }
}
