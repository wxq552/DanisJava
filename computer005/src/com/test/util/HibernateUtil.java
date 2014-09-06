package com.test.util;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateUtil {
 private HibernateTemplate hibernateTemplate;

public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}
@Resource
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}
}
