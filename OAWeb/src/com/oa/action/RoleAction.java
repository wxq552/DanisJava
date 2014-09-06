package com.oa.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.oa.base.BaseAction;
import com.oa.bean.Role;
import com.oa.bean.Privilege;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
@Namespace("/")
public class RoleAction extends BaseAction{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 获取岗位列表
	 * @return
	 */
	private List<Role> list;
	private Role role;
	private Long[] privilegeIds;
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Role> getList() {
		return list;
	}
	public void setList(List<Role> list) {
		this.list = list;
	}
	@Action(value="role_list",results={@Result(name="toList",location="/WEB-INF/jsp/roleAction/list.jsp")})
    public String role_list(){
		this.list=this.roleservice.findAll();
    	return "toList";
    }
    /**
     * 跳转到添加岗位UI
     * @return
     */
	@Action(value="role_addUI",results={@Result(name="toaddUI",location="/WEB-INF/jsp/roleAction/saveUI.jsp")})
    public String role_addUI(){
    	return "toaddUI";
    }
    /**
     * 添加岗位信息
     * @return
     */
	@Action(value="role_add",results={@Result(name="toList",type="redirectAction",params={"actionName","role_list.htm"})})
    public String role_add(){
    	this.roleservice.add(this.role);
    	return "toList";
    }
    /**
     * 跳转到修改岗位UI
     * @return
     */
	@Action(value="role_editUI",results={@Result(name="toeditUI",location="/WEB-INF/jsp/roleAction/editUI.jsp")})
    public String role_editUI(){
    	//准备回显数据
    	this.role=this.roleservice.getById(this.role.getId());
    	return "toeditUI";
    }
    /**
     * 修改岗位信息
     * @return
     */
	@Action(value="role_edit",results={@Result(name="toList",type="redirectAction",params={"actionName","role_list.htm"})})
    public String role_edit(){
    	this.roleservice.update(this.role);
    	return "toList";
    }
    /**
     * 删除岗位信息
     * @return
     */
    @Action(value="role_delete",results={@Result(name="toList",type="redirectAction",params={"actionName","role_list.htm"})})
    public String role_delete(){
    	this.roleservice.delete(role);
    	return "toList";
    }
    /**
     * 转发到设置权限页面
     * @return
     */
    @Action(value="role_setPrivilegeUI",results={@Result(name="toSetPrivilegeUI",location="/WEB-INF/jsp/roleAction/setPrivilegeUI.jsp")})
    public String role_setPrivilegeUI(){
    	this.role=this.roleservice.getById(this.role.getId());
    	ServletActionContext.getRequest().getSession().setAttribute("role",this.role);
    	Set<Privilege> myprivileges=this.role.getPrivileges();
    	List<Privilege> myprivilegesList=new ArrayList<Privilege>();
    	myprivilegesList.addAll(myprivileges);
    	int index=0;
    	this.privilegeIds=new Long[myprivilegesList.size()];
    	for(Privilege p : myprivilegesList){
    		this.privilegeIds[index++]=p.getId();
    	}
    	List<Privilege> privilegeList=this.privilegeservice.findAll();
    	ActionContext.getContext().put("privilegeList",privilegeList);
    	return "toSetPrivilegeUI";
    	
    }
    /**
     * 设置权限
     * @return
     */
    @Action(value="role_setPrivilege",results={@Result(name="toList",type="redirectAction",params={"actionName","role_list.htm"})})
    public String role_setPrivilege(){
    	List<Privilege> myprivileges=this.privilegeservice.findByIds(privilegeIds);
        this.role=(Role) ServletActionContext.getRequest().getSession().getAttribute("role");
        if(myprivileges!=null){
        	this.role.setPrivileges(new HashSet<Privilege>(myprivileges));
        }else{
        	this.role.setPrivileges(null);
        }
    	this.roleservice.update(this.role);
        return "toList";	
    }
}