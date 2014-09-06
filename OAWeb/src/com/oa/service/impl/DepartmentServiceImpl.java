package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Department;
import com.oa.dao.DepartmentDao;
import com.oa.service.DepartmentService;
@Service("departmentservice")
public class DepartmentServiceImpl implements DepartmentService{
  private DepartmentDao departmentdao;

public DepartmentDao getDepartmentdao() {
	return departmentdao;
}
/**
 * 注入DepartmentDao实现类
 * @param departmentdao
 */
@Resource
public void setDepartmentdao(DepartmentDao departmentdao) {
	this.departmentdao = departmentdao;
}
/**
 * 查询所有顶级部门列表
 */
public List<Department> getTopList() {
	return this.departmentdao.getTopList();
}
public boolean add(Department department) {
	return this.departmentdao.save(department);
}
public Department getById(Long id) {
	return this.departmentdao.findById(id);
}
public boolean delete(Department department) {
	return this.departmentdao.delete(department);
}
public List<Department> findChildren(Long parentId) {
	return this.departmentdao.findChildren(parentId);
}
public boolean deleteChildren(List<Department> children) {
	return this.departmentdao.deleteChildren(children);
}
public boolean update(Department department) {
	return this.departmentdao.update(department);
}

}