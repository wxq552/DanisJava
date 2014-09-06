package com.oa.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oa.base.BaseDaoImpl;
import com.oa.bean.Department;
import com.oa.dao.DepartmentDao;
@Repository("departmentdao")
@Transactional(readOnly=false)
@SuppressWarnings("unchecked")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{
	/**
	 * 查询所有顶级部门
	 */
	public List<Department> getTopList() {
		return this.getSession().createQuery("FROM Department d WHERE d.parent.id IS NULL").list();
	}
    /**
     * 查询parentId下的下级部门
     */
	public List<Department> findChildren(Long parentId) {
		return this.getSession().createQuery("FROM Department d WHERE d.parent.id=?")
		.setParameter(0, parentId).list();
	}
	public boolean deleteChildren(List<Department> children) {
		try {
			this.getHibernateTemplate().deleteAll(children);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

}