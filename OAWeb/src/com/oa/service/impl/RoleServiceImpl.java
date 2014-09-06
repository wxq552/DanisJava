package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Role;
import com.oa.dao.RoleDao;
import com.oa.service.RoleService;
@Service("roleservice")
public class RoleServiceImpl implements RoleService{
    private RoleDao roledao;
	public RoleDao getRoledao() {
		return roledao;
	}
	/**
	 * 注入RoleDaoImpl
	 * @param roledao
	 */
	@Resource
	public void setRoledao(RoleDao roledao) {
		this.roledao = roledao;
	}
	/**
	 * 查询所有的Role岗位实体
	 */
	public List<Role> findAll() {
		return this.roledao.findAll();
	}
	public boolean add(Role role) {
		return this.roledao.save(role);
	}
	public boolean delete(Role role) {
		return this.roledao.delete(role);
	}
	public Role getById(Long id) {
		return this.roledao.findById(id);
	}
	public boolean update(Role role) {
		return this.roledao.update(role);
	}
	public List<Role> findByIds(Long[] ids) {
		return this.roledao.findByIds(ids);
	}

}