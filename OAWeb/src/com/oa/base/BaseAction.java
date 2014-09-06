package com.oa.base;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.oa.service.DepartmentService;
import com.oa.service.ForumService;
import com.oa.service.PrivilegeService;
import com.oa.service.ReplyService;
import com.oa.service.RoleService;
import com.oa.service.TopicService;
import com.oa.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("default")
@InterceptorRefs({@InterceptorRef("myStack")})
@Results({@Result(name="noPrivilegeError",location="/noPrivilegeError.jsp"),
	@Result(name="loginUI",location="/WEB-INF/jsp/userAction/loginUI.jsp")})
public class BaseAction extends ActionSupport{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
//=============Service层的注入=============//
 @Resource
 protected RoleService roleservice;
 @Resource
 protected DepartmentService departmentservice;
 @Resource
 protected UserService userservice;
 @Resource
 protected PrivilegeService privilegeservice;
 @Resource
 protected ForumService forumservice;
 @Resource
 protected TopicService topicservice;
 @Resource
 protected ReplyService replyservice;

 
// ===========分页需要的参数=============//
    protected int currentPage=1;
    protected int pageSize=10;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}