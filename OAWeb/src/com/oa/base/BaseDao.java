package com.oa.base;

import java.util.List;

import com.oa.util.QueryHelper;

import com.oa.bean.PageBean;

public interface BaseDao<T> {
	/**
	 * 增加实体
	 * @param entity
	 * @return
	 */
  public boolean save(T entity);
  /**
   * 删除实体
   * @param entity
   * @return
   */
  public boolean delete(T entity);
  /**
   * 更新实体
   * @param entity
   * @return
   */
  public boolean update(T entity);
  /**
   * 查询所有实体
   * @return
   */
  public List<T> findAll();
  /**
   * 根据Id获取实体
   * @param id
   * @return
   */
  public T findById(Long id);
  /**
   * 根据多个Id获取实体列表
   * @param ids
   * @return
   */
  public List<T> findByIds(Long[] ids);
  /**
   * 获取分页信息公共方法
   * @param pageNum
   * @param pageSize
   * @param queryHelper
   * @return
   */
  PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}