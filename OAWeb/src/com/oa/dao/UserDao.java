package com.oa.dao;
import com.oa.base.BaseDao;
import com.oa.bean.User;;
public interface UserDao extends BaseDao<User>{
	/**
	 * 登录验证
	 * @param loginName
	 * @param password
	 * @return
	 */
   public User checkLogin(String loginName,String password);
}