package com.oa.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.util.QueryHelper;

import com.oa.base.BaseAction;
import com.oa.bean.Forum;
import com.oa.bean.PageBean;
import com.oa.bean.Topic;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
@Namespace("/")
public class ForumAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Forum> list;
	private List<Topic> topicList;
	public List<Topic> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	private Forum forum=new Forum();
	
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
     * 查询所有的版块列表
     * @return
     */
	@Action(value="forum_list",results={@Result(name="toList",location="/WEB-INF/jsp/forumAction/list.jsp")})
	public String forum_list(){
		this.list=this.forumservice.findAll();
		return "toList";
	}
	/**
	 * 显示版块的主题列表
	 * @return
	 */
	@Action(value="forum_show",results={@Result(name="toShow",location="/WEB-INF/jsp/forumAction/show.jsp")})
	public String forum_show(){
		ServletActionContext.getRequest().getSession().setAttribute("forum",this.forumservice.getById(this.forum.getId()));
		//this.topicList=this.topicservice.getTopicList(this.forum.getId());
		//分页最终版
		QueryHelper queryHelper=new QueryHelper(Topic.class, "t")
		.addCondition("t.forum.id=?",forum.getId())
		.addOrderProperty("(CASE t.type WHEN 2 THEN 2 ELSE 0 END)",false)
		.addOrderProperty("t.lastUpdateTime",false);//true升序，false倒序
		//PageBean pageBean=this.topicservice.getPageBean(currentPage, pageSize, forum);
        PageBean pageBean=this.topicservice.getPageBean(currentPage, pageSize, queryHelper);		
		ActionContext.getContext().getValueStack().push(pageBean);
		return "toShow";
	}
	
}