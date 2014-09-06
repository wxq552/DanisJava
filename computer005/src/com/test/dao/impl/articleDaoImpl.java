package com.test.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.test.bean.article;
import com.test.dao.articleDao;
import com.test.util.HibernateUtil;
@Component("articledao")
public class articleDaoImpl extends HibernateUtil implements articleDao{

	public boolean addarticle(article art) {
		try {
			this.getHibernateTemplate().save(art);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<article> getnewspage(final int offSet, final int maxResult, final String type) {
	    List list=this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria=session.createCriteria(article.class);
				criteria.addOrder(Order.desc("id"));
				criteria.add(Restrictions.like("type",type));
				criteria.setFirstResult(offSet);
				criteria.setMaxResults(maxResult);
				return criteria.list();
			}
	    	
	    });
	    this.getHibernateTemplate().flush();
		return list;
	}

	public int getarticleCount(String type) {
        List<article> list=this.getHibernateTemplate().find("from article a where a.type=?",type);
        this.getHibernateTemplate().flush();
        int count=list.size();
		return count;
	}

	public article getSingleart(int id) {
		article art=(article) this.getHibernateTemplate().get(article.class, id);
		this.getHibernateTemplate().flush();
		return art;
	}

	public boolean updateart(article art) {
		try {
			this.getHibernateTemplate().update(art);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean deleteart(article art) {
		try {
			this.getHibernateTemplate().delete(art);	
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delartMulti(List<article> list) {
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
