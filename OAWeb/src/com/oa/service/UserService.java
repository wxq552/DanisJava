package com.oa.service;
import java.util.List;

import com.oa.bean.PageBean;
import com.oa.bean.User;
import com.oa.util.QueryHelper;
public interface UserService {
	/**
	 * 查询所有的用户列表
	 * @return
	 */
   public List<User> findAll();
   /**
    * 保存user实体信息
    * @param user
    * @return
    */
   public boolean add(User user);
   /**
    * 删除用户信息实体
    * @param user
    * @return
    */
   public boolean  delete(User user);
   /**
    * 根据Id获取用户信息实体
    * @param id
    * @return
    */
   public User getById(Long id);
   /**
    *更新用户信息实体
    * @param user
    * @return
    */
   public boolean update(User user);
   /**
    * 登录验证
    * @param loginName
    * @param password
    * @return
    */
   public User checkLogin(String loginName,String password);
   /**
    * 分页查询用户信息列表
    * @param currentPage
    * @param pageSize
    * @param queryHelper
    * @return
    */
   public PageBean getPageBean(int currentPage,int pageSize,QueryHelper queryHelper);
}