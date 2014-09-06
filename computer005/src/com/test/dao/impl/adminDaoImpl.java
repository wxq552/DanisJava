package com.test.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.test.bean.admin;
import com.test.bean.surface;
import com.test.dao.adminDao;
import com.test.util.HibernateUtil;
@Component("admindao")
public class adminDaoImpl extends HibernateUtil implements adminDao{

	public admin getsingle(String username) {
		List<admin> list=this.getHibernateTemplate().find("from admin a where a.username=?",username);
		if(list.size()>0){
			this.getHibernateTemplate().flush();
			return list.get(0);
		}
		return null;
	}

	public boolean saveFileInfo(surface sur) {
		try {
			this.getHibernateTemplate().save(sur);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
