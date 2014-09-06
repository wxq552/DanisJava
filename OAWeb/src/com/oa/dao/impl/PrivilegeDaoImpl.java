package com.oa.dao.impl;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oa.base.BaseDaoImpl;
import com.oa.bean.Privilege;
import com.oa.dao.PrivilegeDao;
@Repository("privilegedao")
@SuppressWarnings("unchecked")
@Transactional
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	
	public List<Privilege> getTopPrivilege() {
		return this.getSession().createQuery("FROM Privilege p WHERE p.parent.id IS NULL").list();
	}

	public Collection<String> getAllPrivilegeUrls() {
		return getSession().createQuery(//
		"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL")//
		.list();
	}

}
