package com.oa.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.base.BaseAction;
import com.oa.bean.Forum;
@Controller
@Scope("prototype")
@Namespace("/")
public class ForumManagerAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Forum> list;
	private Forum forum;
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public List<Forum> getList() {
		return list;
	}
	public void setList(List<Forum> list) {
		this.list = list;
	}
	/**
	 * 查询版块列表
	 * @return
	 */
	@Action(value="forumManage_list",results={@Result(name="toList",location="/WEB-INF/jsp/forumManageAction/list.jsp")})
	public String forum_list(){
		this.list=this.forumservice.findAll();
		return "toList";
	} 
	/**
	 * 转发到新建版块页面
	 * @return
	 */
	@Action(value="forumManage_addUI",results={@Result(name="toaddUI",location="/WEB-INF/jsp/forumManageAction/saveUI.jsp")})
    public String forumManage_addUI(){
    	return "toaddUI";
    }
	/**
	 * 添加新版块
	 * @return
	 */
	@Action(value="forumManage_add",results={@Result(name="toList",type="redirectAction",params={"actionName","forumManage_list.htm"})})
	public String forumManage_add(){
		this.forumservice.add(this.forum);
		return "toList";
	}
	/**
	 * 删除版块
	 * @return
	 */
	@Action(value="forumManage_delete",results={@Result(name="toList",type="redirectAction",params={"actionName","forumManage_list.htm"})})
	public String forumManage_delete(){
		this.forumservice.delete(this.forum);
		return "toList";
	}
	/**
	 * 转发到修改页面
	 * @return
	 */
	@Action(value="forumManage_editUI",results={@Result(name="toeditUI",location="/WEB-INF/jsp/forumManageAction/editUI.jsp")})
	public String forumManage_editUI(){
		this.forum=this.forumservice.getById(this.forum.getId());
		return "toeditUI";
	}
	/**
	 * 修改版块
	 * @return
	 */
	@Action(value="forumManage_edit",results={@Result(name="toList",type="redirectAction",params={"actionName","forumManage_list.htm"})})
	public String forumManage_edit(){
		this.forumservice.update(this.forum);
	    return "toList";
	}
	/**
	 * 上移
	 * @return
	 */
	@Action(value="forumManage_moveUp",results={@Result(name="toList",type="redirectAction",params={"actionName","forumManage_list.htm"})})
	public String moveUp(){
        this.forumservice.moveup(this.forum.getId());
        this.list=this.forumservice.findAll();
	    return "toList";   
	}
	/**
	 * 下移
	 * @return
	 */
	@Action(value="forumManage_moveDown",results={@Result(name="toList",type="redirectAction",params={"actionName","forumManage_list.htm"})})
	public String moveDown(){
		this.forumservice.movedown(this.forum.getId());
		this.list=this.forumservice.findAll();
		return "toList";
	}
	
}