package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.PageBean;
import com.oa.bean.User;
import com.oa.dao.UserDao;
import com.oa.service.UserService;
import com.oa.util.QueryHelper;
@Service("userservice")
public class UserServiceImpl implements UserService{
 private UserDao userdao;

public UserDao getUserdao() {
	return userdao;
}
@Resource
public void setUserdao(UserDao userdao) {
	this.userdao = userdao;
}
public List<User> findAll() {
	return this.userdao.findAll();
}
public boolean add(User user) {
	return this.userdao.save(user);
}
public boolean delete(User user) {
	return this.userdao.delete(user);
}
public User getById(Long id) {
	return this.userdao.findById(id);
}
public boolean update(User user) {
	return this.userdao.update(user);
}
public User checkLogin(String loginName, String password) {
	return this.userdao.checkLogin(loginName, password);
}
public PageBean getPageBean(int currentPage, int pageSize,
		QueryHelper queryHelper) {
	return this.userdao.getPageBean(currentPage, pageSize, queryHelper);
}

}
