package com.test.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.test.bean.job;
import com.test.bean.msg;
import com.test.dao.jobDao;
import com.test.util.HibernateUtil;
@Component("jobdao")
public class jobDaoImpl extends HibernateUtil implements jobDao{

	public boolean addJob(job job) {
	    try {
			this.getHibernateTemplate().save(job);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public int getjobcount() {
		List<job> list=this.getHibernateTemplate().find("from job");
		this.getHibernateTemplate().flush();
		int count=list.size();
		return count;
	}

	public List<job> getjobpage(final int offSet, final int maxResult) {
		List list=this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria=session.createCriteria(job.class);
				criteria.addOrder(Order.desc("id"));
				criteria.setFirstResult(offSet);
				criteria.setMaxResults(maxResult);
				return criteria.list();
			}
			
		});
		this.getHibernateTemplate().flush();
		return list;
	}

	public boolean deletesinglejob(job job) {
		try {
			this.getHibernateTemplate().delete(job);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public job getsinglejob(int id) {
		job j=(job) this.getHibernateTemplate().get(job.class, id);
		this.getHibernateTemplate().flush();
		return j;
	}

	public boolean updatejob(job job) {
		try {
			this.getHibernateTemplate().update(job);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}

	public boolean deleteMulti(List<job> list) {
		try {
			this.getHibernateTemplate().deleteAll(list);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
  
}
