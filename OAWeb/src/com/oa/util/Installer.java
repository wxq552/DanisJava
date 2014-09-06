package com.oa.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.oa.bean.Privilege;

import com.oa.bean.User;
@Component("installer")
public class Installer extends HibernateDaoSupport{

@Autowired
  public void setMySessionFactory(SessionFactory sessionFactory) {
     	super.setSessionFactory(sessionFactory);
}

/**
 * 执行安装，配置初始化数据
 */
@Transactional
public void install(){
	Session session=this.getSession();
	//  ===========设置超级管理员============
	User user=new User();
	user.setLoginName("admin");
	user.setName("超级管理员");
	user.setPassword(DigestUtils.md5Hex("admin"));
	session.save(user);
   //  ===========设置超级管理员============
	
	
 //  ===========配置权限数据==============
	Privilege menu, menu1, menu2, menu3, menu4, menu5;
	
	menu =new Privilege("系统管理",null,null);
	menu1=new Privilege("岗位管理","/role_list.htm",menu);
	menu2=new Privilege("部门管理","/department_list.htm",menu);
	menu3=new Privilege("用户管理","/user_list.htm",menu);
	session.save(menu);
	session.save(menu1);
	session.save(menu2);
	session.save(menu3);
	
	session.save(new Privilege("岗位列表", "/role_list.htm", menu1));
	session.save(new Privilege("岗位删除", "/role_delete.htm", menu1));
	session.save(new Privilege("岗位添加", "/role_add.htm", menu1));
	session.save(new Privilege("岗位修改", "/role_edit.htm", menu1));

	session.save(new Privilege("部门列表", "/department_list.htm", menu2));
	session.save(new Privilege("部门删除", "/department_delete.htm", menu2));
	session.save(new Privilege("部门添加", "/department_add.htm", menu2));
	session.save(new Privilege("部门修改", "/department_edit.htm", menu2));

	session.save(new Privilege("用户列表", "/user_list.htm", menu3));
	session.save(new Privilege("用户删除", "/user_delete.htm", menu3));
	session.save(new Privilege("用户添加", "/user_add.htm", menu3));
	session.save(new Privilege("用户修改", "/user_edit.htm", menu3));
	session.save(new Privilege("初始化密码", "/user_initPassword.htm", menu3));

	// --------------------
	menu = new Privilege("网上交流", null, null);
	menu1 = new Privilege("论坛管理", "/forumManage_list.htm", menu);
	menu2 = new Privilege("论坛", "/forum_list.htm", menu);
	session.save(menu);
	session.save(menu1);
	session.save(menu2);

	// --------------------
	menu = new Privilege("审批流转", null, null);
	menu1 = new Privilege("审批流程管理", "/processDefinition_list.htm", menu);
	menu2 = new Privilege("申请模板管理", "/template_list.htm", menu);
	menu3 = new Privilege("起草申请", "/flow_templateList.htm", menu);
	menu4 = new Privilege("待我审批", "/flow_myTaskList.htm", menu);
	menu5 = new Privilege("我的申请查询", "/flow_myApplicationList.htm", menu);
	session.save(menu);
	session.save(menu1);
	session.save(menu2);
	session.save(menu3);
	session.save(menu4);
	session.save(menu5);
	
}
public static void main(String[] args){
	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	Installer installer=(Installer) ac.getBean("installer");
	installer.install();
}
}