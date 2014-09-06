package com.oa.util;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.oa.bean.Privilege;
import com.oa.service.impl.PrivilegeServiceImpl;

public class InitListener implements ServletContextListener{
   //监听WEB容器关闭时调用的方法
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
    //监听WEB容器启动时初始化调用的方法
	public void contextInitialized(ServletContextEvent sce) {
	
		// ======获取Spring容器的ApplicationContext
	    ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
	    // ======获取与权限相关的Service对象
	    PrivilegeServiceImpl privilegeService=(PrivilegeServiceImpl) ac.getBean("privilegeservice");
	    // ======获取所有顶级权限，保存到application对象中
	    List<Privilege> topPrivilegeList=privilegeService.getTopPrivilege();
	    sce.getServletContext().setAttribute("topPrivilegeList", topPrivilegeList);
	    System.out.println("------------> 已准备数据topPrivilegeList <------------");
	    
	 // 准备数据：allPrivilegeUrls
		Collection<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		sce.getServletContext().setAttribute("allPrivilegeUrls", allPrivilegeUrls);
		System.out.println("------------> 已准备数据allPrivilegeUrls <------------");
	}

}