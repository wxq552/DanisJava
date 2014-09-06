package com.oa.util;

import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
/**
 *重写OpenSessionInViewFilter解决因引入OpenSessionInViewFilter解决懒加载问题，
 *而将Session的事务模型设置为readonly造成不可写异常
 * @author Administrator
 *
 */
public class MyOpenSessionInViewFilter extends OpenSessionInViewFilter{
	protected Session getSession(SessionFactory sessionFactory)
    throws DataAccessResourceFailureException {
    Session session = SessionFactoryUtils.getSession(sessionFactory, true);
    session.setFlushMode(FlushMode.COMMIT);
    return session;
}

protected void closeSession(Session session, SessionFactory factory) {
session.flush();
super.closeSession(session, factory);
}
}