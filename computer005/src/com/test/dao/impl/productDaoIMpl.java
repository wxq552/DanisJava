package com.test.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.test.bean.production;
import com.test.dao.productDao;
import com.test.util.HibernateUtil;
@Component("productdao")
public class productDaoIMpl extends HibernateUtil implements productDao{

	public boolean addpro(production pro) {
		try {
			this.getHibernateTemplate().save(pro);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public List<production> getproducts(final int offSet, final int maxResult) {
		List list=this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria=session.createCriteria(production.class);
				criteria.addOrder(Order.desc("id"));
				criteria.setFirstResult(offSet);
				criteria.setMaxResults(maxResult);
				return criteria.list();
			}
			
		});
		this.getHibernateTemplate().flush();
		return list;
	}

	public int getprocount() {
		int count=this.getHibernateTemplate().find("from production").size();
		this.getHibernateTemplate().flush();
		return count;
	}

	public boolean delete(production pro) {
		try {
			this.getHibernateTemplate().delete(pro);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public production getonepro(int id) {
		production pro=(production) this.getHibernateTemplate().get(production.class, id);
		this.getHibernateTemplate().flush();
		return pro;
	}

	public boolean updatepro(production pro) {
		try {
			this.getHibernateTemplate().update(pro);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletemulti(List<production> dellist) {
		try {
			this.getHibernateTemplate().deleteAll(dellist);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
					
	}

	public List<String> findProByType() {
		List list=this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria  criteria=session.createCriteria(production.class);
				criteria.addOrder(Order.desc("id"));
				criteria.setProjection(Projections.groupProperty("type"));//设置分组查询
				criteria.setFirstResult(0);
				criteria.setMaxResults(5);
				return criteria.list();
			}
		});
		this.getHibernateTemplate().flush();
		return list;
	}

	public int getprocountBytype(String type) {
		int count=this.getHibernateTemplate().find("from production p where p.type=?",type).size();
		this.getHibernateTemplate().flush();
		return count;
	}

	public List<production> getproPageType(final int offSet, final int maxResult, final String type) {
		List list=this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria=session.createCriteria(production.class);
				criteria.addOrder(Order.desc("id"));
				criteria.add(Restrictions.like("type", type));
				criteria.setFirstResult(offSet);
				criteria.setMaxResults(maxResult);
				return criteria.list();
			}
			
		});
		this.getHibernateTemplate().flush();
		return list;
	}

}
