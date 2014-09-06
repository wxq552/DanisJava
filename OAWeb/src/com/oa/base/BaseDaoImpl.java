package com.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.oa.bean.PageBean;
import com.oa.bean.Topic;
import com.oa.util.QueryHelper;
/**
 * 公共实现方法的集合类
 * @author Administrator
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")  //注解让编译器忽略警告信息
@Transactional(readOnly=false)   //注解开启事务
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class<T> clazz;
	/**
	 * 注入SessionFactory
	 * @param sessionFactory
	 */
	
	
	public BaseDaoImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		System.out.println("clazz ---> " + clazz);
	}
	
	@Autowired  
	public void setMySessionFactory(SessionFactory sessionFactory){  
	    super.setSessionFactory(sessionFactory);  
	}  
	/**
	 * 删除实体
	 */
	public boolean delete(T entity) {
		try {
			this.getHibernateTemplate().delete(entity);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}
    /**
     * 查找所有实体信息
     */
	public List<T> findAll() {
		List<T> list=this.getSession().createQuery("FROM "+clazz.getSimpleName()).list();
		this.getHibernateTemplate().flush();
		return list;
	}

	/**
	 * 根据Id查找实体
	 */
	public T findById(Long id) {
		if(id==null){
			return null;
		}
		T entity=(T) this.getHibernateTemplate().get(clazz, id);
		this.getHibernateTemplate().flush();
		return entity;
	}
     /**
      * 保存实体
      */
	public boolean save(T entity) {
		try {
			this.getHibernateTemplate().save(entity);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		    return false;
		}
	}
    /**
     * 更新实体
     */
	public boolean update(T entity) {
		try {
			this.getHibernateTemplate().update(entity);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<T> findByIds(Long[] ids) {
		if(ids==null || ids.length==0){
			return null;
		}else{
		    return this.getSession().createQuery("FROM "+clazz.getSimpleName()+" WHERE id IN (:ids)")
		    .setParameterList("ids",ids)
		    .list();
		}
	}

	// 公共的查询分页信息的方法（最终版）
	public PageBean getPageBean(int currentPage, int pageSize, QueryHelper queryHelper) {
		System.out.println("-------> BaseDaoImpl.getPageBean( int pageNum, int pageSize, QueryHelper queryHelper )");

		// 参数列表
		List<Object> parameters = queryHelper.getParameters();

		// 查询本页的数据列表
		Query listQuery = getSession().createQuery(queryHelper.getListQueryHql()); // 创建查询对象
		if (parameters != null) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((currentPage - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 执行查询

		// 查询总记录数量
		Query countQuery = getSession().createQuery(queryHelper.getCountQueryHql());
		if (parameters != null) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // 执行查询

		return new PageBean(currentPage, pageSize, count.intValue(), list);
	}


}