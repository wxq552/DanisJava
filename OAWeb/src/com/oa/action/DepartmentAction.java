package com.oa.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.oa.bean.Department;
import com.oa.base.BaseAction;
import com.oa.util.DepartmentUtils;
import com.opensymphony.xwork2.ActionContext;
@Namespace("/")
@Controller
@Scope("prototype")
@SuppressWarnings("unchecked")
public class DepartmentAction extends BaseAction{
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private List<Department> list;
    private Department department;
    private Long parentId;
    private int layout=0;
    
    public int getLayout() {
		return layout;
	}
	public void setLayout(int layout) {
		this.layout = layout;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Department> getList() {
		return list;
	}
	public void setList(List<Department> list) {
		this.list = list;
	}
/**
    * 查询顶级部门列表
    * @return
    */
	@Action(value="department_list",results={@Result(name="toList",location="/WEB-INF/jsp/departmentAction/list.jsp")})
	public String toplist(){
	  this.list=this.departmentservice.getTopList();
	  return "toList";
  }
	/**
	 * 新建部门
	 * @return
	 */
	@Action(value="department_addUI",results={@Result(name="toaddUI",location="/WEB-INF/jsp/departmentAction/saveUI.jsp")})
	public String department_addUI(){
	  List<Department> toplist=this.departmentservice.getTopList();
	  List<Department> departmentList=DepartmentUtils.getAllDepartments(toplist);
	  ActionContext.getContext().put("departmentList",departmentList);
	  return "toaddUI";
	}
	@Action(value="department_add",results={@Result(name="toList",type="redirectAction",params={"actionName","department_list.htm"})})
	public String department_add(){
		if(this.parentId==null){
			this.department.setParent(null);
			this.departmentservice.add(this.department);
		}else{
			Department parent=this.departmentservice.getById(parentId);
			this.department.setParent(parent);
			this.departmentservice.add(this.department);
		}
		return "toList";
	}
	/**
	 * 查看子部门列表
	 * @return
	 */
	@Action(value="children_list",results={@Result(name="toList",location="/WEB-INF/jsp/departmentAction/list.jsp")})
	public String department_list(){
		this.list= this.departmentservice.findChildren(this.parentId);
		if(this.layout==1){
			List<Department> toplist=this.departmentservice.getTopList();
			ServletActionContext.getRequest().getSession().setAttribute("prev"+layout,toplist);
			ServletActionContext.getRequest().getSession().setAttribute("prev"+layout+1, this.list);
			this.layout=2;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("prev"+layout,this.list);
		}
		return "toList";
	}
	@Action(value="department_delete",results={@Result(name="toList",type="redirectAction",params={"actionName","department_list.htm"})})
	public String department_delete(){
		List<Department> children=this.departmentservice.findChildren(this.department.getId());
		this.departmentservice.deleteChildren(children);
		this.departmentservice.delete(this.department);
		return "toList";
	}
	/**
	 * 获取上一层列表数据
	 * @return
	 */
	@Action(value="department_prev_list",results={@Result(name="toList",location="/WEB-INF/jsp/departmentAction/list.jsp")})
	public String department_prev_list(){
		this.list=(List<Department>) ServletActionContext.getRequest().getSession().getAttribute("prev"+layout);
		return "toList";
	}
	/**
	 * 转到修改页面
	 * @return
	 */
    @Action(value="department_editUI",results={@Result(name="toeditUI",location="/WEB-INF/jsp/departmentAction/editUI.jsp")})
	public String department_editUI(){
    	List<Department> toplist=this.departmentservice.getTopList();
  	    List<Department> departmentList=DepartmentUtils.getAllDepartments(toplist);
  	    ActionContext.getContext().put("departmentList",departmentList);
		this.department=this.departmentservice.getById(this.department.getId());//准备回显数据
		if(this.department.getParent()==null){
			this.parentId=null;
		}else{
		this.parentId=this.department.getParent().getId();
		}
		return "toeditUI";
	}
    @Action(value="department_edit",results={@Result(name="toList",type="redirectAction",params={"actionName","department_list.htm"})})
    public String department_edit(){
        Department parent=this.departmentservice.getById(parentId);
        this.department.setParent(parent);
        this.departmentservice.update(this.department);
        return "toList";
    }
    
}