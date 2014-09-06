package com.oa.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oa.base.BaseDaoImpl;
import com.oa.bean.User;
import com.oa.dao.UserDao;
@Repository("userdao")
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public User checkLogin(String loginName, String password) {
		User user=(User) this.getSession().createQuery("FROM User u where u.loginName=? AND u.password=?")
		.setParameter(0,loginName)
		.setParameter(1, password)
		.uniqueResult();
		return user;
	}

}
