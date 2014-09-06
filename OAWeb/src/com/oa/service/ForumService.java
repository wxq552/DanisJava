package com.oa.service;
import java.util.List;

import com.oa.bean.Forum;
public interface ForumService {
	/**
	 * 查询所有的版块列表
	 * @return
	 */
  public List<Forum> findAll();
  /**
   * 保存版块实体
   * @param forum
   * @return
   */
  public boolean add(Forum forum);
  /**
   * 删除版块
   * @param forum
   * @return
   */
  public boolean delete(Forum forum);
  /**
   * 根据Id获取版块
   * @param id
   * @return
   */
  public Forum getById(Long id);
  /**
   * 更新版块
   * @param forum
   * @return
   */
  public boolean update(Forum forum);
  /**
   * 上移
   * @param id
   */
  public void moveup(Long id);
  /**
   * 下移
   * @param id
   */
  public void movedown(Long id);
}