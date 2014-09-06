package com.oa.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.base.BaseAction;
import com.oa.bean.Department;
import com.oa.bean.PageBean;
import com.oa.bean.Role;
import com.oa.bean.User;
import com.oa.util.DepartmentUtils;
import com.oa.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
@Namespace("/")
@SuppressWarnings("unchecked")
public class UserAction extends BaseAction{
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> list;
	private User user=new User();
	private Long[] roleIds;
	private Long departmentId;
	
    public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
    /**
    * 查询所有的用户
    * @return
    */
	@Action(value="user_list",results={@Result(name="toList",location="/WEB-INF/jsp/userAction/list.jsp")})
	public String user_list(){
	   //this.list=this.userservice.findAll();
	   QueryHelper queryHelper=new QueryHelper(User.class,"u");
	   PageBean pageBean=this.userservice.getPageBean(currentPage, pageSize, queryHelper);
	   ActionContext.getContext().getValueStack().push(pageBean);
	   return "toList";
   }
	/**
	 * 转发到添加用户页面
	 * @return
	 */
	@Action(value="user_addUI",results={@Result(name="toaddUI",location="/WEB-INF/jsp/userAction/saveUI.jsp")})
	public String user_addUI(){
		  List<Department> toplist=this.departmentservice.getTopList();
		  List<Department> departmentList=DepartmentUtils.getAllDepartments(toplist);
		  ActionContext.getContext().put("departmentList",departmentList);
		  List<Role> roleList=this.roleservice.findAll();
		  ActionContext.getContext().put("roleList", roleList);
 		return "toaddUI";
	}
	/**
	 * 添加用户信息
	 * @return
	 */
	@Action(value="user_add",results={@Result(name="toList",type="redirectAction",params={"actionName","user_list.htm"})})
	public String user_add(){
	    Department department=this.departmentservice.getById(departmentId);
	    this.user.setDepartment(department);
	    List<Role> rolelist=this.roleservice.findByIds(this.roleIds);
	    if(rolelist!=null){
	    	this.user.setRoles(new HashSet<Role>(rolelist));
	    }else{
	    	this.user.setRoles(null);
	    }
	    this.userservice.add(this.user);
	    return "toList";	
	}
	/**
	 * 删除用户信息
	 */
	@Action(value="user_delete",results={@Result(name="toList",type="redirectAction",params={"actionName","user_list.htm"})})
	public String user_delete(){
		this.userservice.delete(this.user);
		return "toList";
	}
	/**
	 * 转发到修改用户信息页面
	 * @return
	 */
	@Action(value="user_editUI",results={@Result(name="toeditUI",location="/WEB-INF/jsp/userAction/editUI.jsp")})
	public String user_editUI(){
		//准备回显数据
		 List<Department> toplist=this.departmentservice.getTopList();
		 List<Department> departmentList=DepartmentUtils.getAllDepartments(toplist);
		 ActionContext.getContext().put("departmentList",departmentList);
		 List<Role> roleList=this.roleservice.findAll();
		 ActionContext.getContext().put("roleList", roleList);
		 this.user=this.userservice.getById(this.user.getId());
		 this.departmentId=this.user.getDepartment().getId();
		 Set<Role> roles=this.user.getRoles();
		 List<Role> rolelist=new ArrayList<Role>();
		 rolelist.addAll(roles);
		 int index=0;
		 this.roleIds=new Long[rolelist.size()];
		 for(Role r : rolelist){
			 this.roleIds[index++]=r.getId();
		 }
	     return "toeditUI"; 	
	}
	/**
	 * 修改用户信息
	 * @return
	 */
	@Action(value="user_edit",results={@Result(name="toList",type="redirectAction",params={"actionName","user_list.htm"})})
	public String user_edit(){
		Department department=this.departmentservice.getById(this.departmentId);
		this.user.setDepartment(department);
		List<Role> rolelist=this.roleservice.findByIds(this.roleIds);
		//User u=this.userservice.getById(this.user.getId());
		//this.user.setPassword(u.getPassword());
	    if(rolelist!=null){
	    	this.user.setRoles(new HashSet<Role>(rolelist));
	    }else{
	    	this.user.setRoles(null);
	    }
		this.userservice.update(this.user);
	    return "toList";	 
	}
	/**
	 * 初始化密码为1234，并进行MD5加密
	 * @return
	 */
	@Action(value="user_initPassword",results={@Result(name="toList",type="redirectAction",params={"actionName","user_list.htm"})})
	public String user_initPassword(){
		this.user=this.userservice.getById(this.user.getId());
		String initpass=DigestUtils.md5Hex("1234");
		this.user.setPassword(initpass);
		this.userservice.update(this.user);
		return "toList";
	}
	/**
	 * 转到登录页面
	 * @return
	 */
	@Action(value="user_loginUI",results={@Result(name="loginUI",location="/WEB-INF/jsp/userAction/loginUI.jsp")})
	public String user_loginUI(){
		return "loginUI";
	}
	/**
	 * 登录验证
	 * @return
	 */
	@Action(value="user_login",results={@Result(name="loginUI",location="/WEB-INF/jsp/userAction/loginUI.jsp"),
			@Result(name="toIndex",location="/WEB-INF/jsp/homeAction/index.jsp")})
	public String user_login(){
		if(this.user.getLoginName()!=null&&this.user.getPassword()!=null&&!this.user.getLoginName().equals("")&&!this.user.getPassword().equals("")){
			User u=this.userservice.checkLogin(this.user.getLoginName(),DigestUtils.md5Hex(this.user.getPassword()));
			if(u==null){
				this.addFieldError("loginError","用户名或密码错误！");
				return "loginUI";
			}else{
				ActionContext.getContext().getSession().put("user",u);
				return "toIndex";
			}	
		}else{
			//若已登录，刷新/user_login.html链接时，先判断用户是否已登录，若登录就转发到index.jsp
			User u=(User) ActionContext.getContext().getSession().get("user");
			if(u!=null){
				return "toIndex";
			}
			this.addFieldError("loginempty","用户名或密码不能为空！");
			return "loginUI";
		}
		
		
	}
	/**
	 * 注销
	 * @return
	 */
	@Action(value="user_logout",results={@Result(name="toLogout",location="/WEB-INF/jsp/userAction/logout.jsp")})
	public String user_logout(){
		ActionContext.getContext().getSession().remove("user");
		return "toLogout";
	}
 
}