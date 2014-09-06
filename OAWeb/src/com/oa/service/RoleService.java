package com.oa.service;
import java.util.List;

import com.oa.bean.Role;
public interface RoleService {
	/**
	 * 查询所有 岗位
	 * @return
	 */
   public List<Role> findAll();
   /**
    * 保存岗位实体
    * @param role
    * @return
    */
   public boolean add(Role role);
   /**
    * 删除岗位实体
    * @param role
    * @return
    */
   public boolean delete(Role role);
   /**
    * 根据Id获取岗位实体
    * @param id
    * @return
    */
   public Role getById(Long id);
   /**
    * 更新岗位实体
    * @param role
    * @return
    */
   public boolean update(Role role);
   /**
    * 根据多个Id查询role列表信息
    * @param ids
    * @return
    */
   public List<Role> findByIds(Long[] ids);
}