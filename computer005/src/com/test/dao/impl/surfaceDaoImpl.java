package com.test.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import com.test.bean.surface;
import com.test.dao.surfaceDao;
import com.test.util.HibernateUtil;
@Component("surfacedao")
public class surfaceDaoImpl extends HibernateUtil implements surfaceDao{

	public List<surface> getallsurface() {
		List list=this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria=session.createCriteria(surface.class);
				criteria.addOrder(Order.desc("id"));
				criteria.setFirstResult(0);
				criteria.setMaxResults(3);
				return criteria.list();
			}
			
		});
		this.getHibernateTemplate().flush();
		return list;
	}

}
