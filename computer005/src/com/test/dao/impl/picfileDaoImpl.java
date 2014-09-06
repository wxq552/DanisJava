package com.test.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.test.bean.picfile;
import com.test.dao.picfileDao;
import com.test.util.HibernateUtil;
@Component("picfiledao")
public class picfileDaoImpl extends HibernateUtil implements picfileDao{

	public boolean savepic(picfile picfile) {
		try {
			this.getHibernateTemplate().save(picfile);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public List<picfile> getpagepic(final int firstResult, final int maxResult, final String type) {
		List list=this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria=session.createCriteria(picfile.class);
				criteria.add(Restrictions.like("type",type));
				criteria.setFirstResult(firstResult);
				criteria.setMaxResults(maxResult);
				return criteria.list();
			}
			
		});
		this.getHibernateTemplate().flush();
		return list;
	}

	public int getpiccount(String type) {
		List<picfile> list=this.getHibernateTemplate().find("from picfile where type=?",new String[]{type});
		int count=list.size();
		this.getHibernateTemplate().flush();
		return count;
	}

	public boolean delmulti(List<picfile> dellist) {
		try {
			this.getHibernateTemplate().deleteAll(dellist);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delOnepic(picfile picfile) {
		try {
			this.getHibernateTemplate().delete(picfile);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	public picfile getOnepic(int id) {
        picfile picfile=(picfile) this.getHibernateTemplate().get(picfile.class, id);
		return picfile;
	}

	public boolean updateOnePic(picfile picfile) {
		try {
			this.getHibernateTemplate().update(picfile);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}
  
}
