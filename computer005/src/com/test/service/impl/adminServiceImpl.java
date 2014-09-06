package com.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.test.bean.admin;
import com.test.bean.msg;
import com.test.bean.surface;
import com.test.dao.adminDao;
import com.test.service.adminService;
@Component("adminservice")
public class adminServiceImpl implements adminService{
  private adminDao admindao;

public adminDao getAdmindao() {
	return admindao;
}
@Resource
public void setAdmindao(adminDao admindao) {
	this.admindao = admindao;
}
public admin getone(String username) {
	return this.admindao.getsingle(username);
}
public boolean savefileinfo(surface sur) {
	return this.admindao.saveFileInfo(sur);
}

}
