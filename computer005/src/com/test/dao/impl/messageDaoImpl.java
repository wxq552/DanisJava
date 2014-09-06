package com.test.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.test.bean.msg;
import com.test.dao.messageDao;
import com.test.util.HibernateUtil;
@Component("messagedao")
public class messageDaoImpl extends HibernateUtil implements messageDao{

	public List<msg> getmsg(final int offSet, final int maxResult) {
		List list=this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria=session.createCriteria(msg.class);
				criteria.addOrder(Order.desc("id"));
				criteria.setFirstResult(offSet);
				criteria.setMaxResults(maxResult);
				return criteria.list();
			}
			
		});
		this.getHibernateTemplate().flush();
		return list;
	}

	

	public boolean deletesingle(msg msg) {
		try {
			this.getHibernateTemplate().delete(msg);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}



	public int getmsgcount() {
		List list=this.getHibernateTemplate().find("from msg");
		this.getHibernateTemplate().flush();
		int count=list.size();
		return count;
	}



	public boolean deletemulti(List<msg> list) {
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



	public msg getsinglebean(int id) {
		msg m=(msg) this.getHibernateTemplate().get(msg.class, id);
		this.getHibernateTemplate().flush();
		return m;
	}



	public boolean addmes(msg mes) {
		try {
			this.getHibernateTemplate().save(mes);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}





}
