package com.oa.dao;

import java.util.Collection;
import java.util.List;

import com.oa.base.BaseDao;
import com.oa.bean.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege>{
	/**
	 * 获取顶级权限列表
	 * @return
	 */
   public List<Privilege> getTopPrivilege();
   /**
    * 获得所有权限数据
    * @return
    */
   public Collection<String> getAllPrivilegeUrls();
}