package com.oa.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Privilege;
import com.oa.dao.PrivilegeDao;
import com.oa.service.PrivilegeService;
@Service("privilegeservice")
public class PrivilegeServiceImpl implements PrivilegeService{
  private PrivilegeDao privilegedao;

public PrivilegeDao getPrivilegedao() {
	return privilegedao;
}
@Resource
public void setPrivilegedao(PrivilegeDao privilegedao) {
	this.privilegedao = privilegedao;
}
public List<Privilege> findAll() {
	return this.privilegedao.findAll();
}
public List<Privilege> findByIds(Long[] ids) {
	return this.privilegedao.findByIds(ids);
}
public List<Privilege> getTopPrivilege() {
	return this.privilegedao.getTopPrivilege();
}
public Collection<String> getAllPrivilegeUrls() {
	return this.privilegedao.getAllPrivilegeUrls();
}
}
