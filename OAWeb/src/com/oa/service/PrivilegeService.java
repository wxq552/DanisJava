package com.oa.service;
import java.util.Collection;
import java.util.List;

import com.oa.bean.Privilege;
public interface PrivilegeService {
	/**
	 * 获取所有权限
	 * @return
	 */
  public List<Privilege> findAll();
  /**
   * 根据多个id查询多个权限
   * @param ids
   * @return
   */
  public List<Privilege> findByIds(Long[] ids);
  /**
   * 获得顶级权限
   * @return
   */
  public List<Privilege> getTopPrivilege();
  /**
   * 获得所有的权限数据
   * @return
   */
  public Collection<String> getAllPrivilegeUrls();
}