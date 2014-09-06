package com.oa.service;
import java.util.List;

import com.oa.bean.Department;
public interface DepartmentService {
	/**
	 * 查询所有顶级部门
	 * @return
	 */
   public List<Department> getTopList();
   /**
    * 保存部门实体
    * @param department
    * @return
    */
   public boolean add(Department department);
   /**
    * 根据Id获取部门实体
    * @param id
    * @return
    */
   public Department getById(Long id);
   /**
    * 删除部门实体
    * @param department
    * @return
    */
   public boolean delete(Department department);
   /**
    * 根据parentId查询下级部门列表
    * @param parentId
    * @return
    */
   public List<Department> findChildren(Long parentId);
   /**
    * 删除某上级部门的所有下级部门
    * @param children
    * @return
    */
   public boolean deleteChildren(List<Department> children);
   /**
    * 更新部门实体
    * @param department
    * @return
    */
   public boolean update(Department department);
}