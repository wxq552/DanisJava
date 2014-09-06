package com.oa.dao;
import java.util.List;

import com.oa.base.BaseDao;
import com.oa.bean.Department;
public interface DepartmentDao extends BaseDao<Department>{
	/**
	 * 查询顶级部门列表
	 * @return
	 */
  public List<Department> getTopList();
  /**
   * 根据parentId查询下级部门列表
   * @param parentId
   * @return
   */
  public List<Department> findChildren(Long parentId);
  /**
   * 删除某上级部门下的所有下级部门
   * @param children
   * @return
   */
  public boolean deleteChildren(List<Department> children);
}