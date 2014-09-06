package com.oa.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.base.BaseAction;
import com.oa.bean.Forum;
import com.oa.bean.PageBean;
import com.oa.bean.Reply;
import com.oa.bean.Topic;
import com.oa.bean.User;
import com.oa.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
@Namespace("/")
public class TopicAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Topic topic;
	private Long id;
	private List<Reply> replyList;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public List<Reply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	/**
	 * 转发到发表新帖页面
	 * @return
	 */
	@Action(value="topic_addUI",results={@Result(name="toaddUI",location="/WEB-INF/jsp/topicAction/addUI.jsp")})
	public String topic_addUI(){
        return "toaddUI";		
	}
	/**
	 * 保存主题信息
	 * @return
	 */
	@Action(value="topic_add",results={@Result(name="toShow",type="redirectAction",params={"actionName","topic_show.htm","id","%{id}"})})
	public String topic_add(){
	    User author=(User) ActionContext.getContext().getSession().get("user");
	    Forum forum=(Forum) ServletActionContext.getRequest().getSession().getAttribute("forum");
	    Date posttime=new Date();
	    this.topic.setAuthor(author);
	    this.topic.setPostTime(posttime);
	    this.topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
	    this.topic.setForum(forum);
	    this.id=this.topicservice.add(this.topic);
		return "toShow";
	}
	@Action(value="topic_show",results={@Result(name="show",location="/WEB-INF/jsp/topicAction/show.jsp")})
	public String topic_show(){
	//准备主题数据
	//System.out.println(this.id);
	this.topic=this.topicservice.getById(this.id);
	//准备回复列表数据
	//this.replyList=this.replyservice.getByTopic(this.topic);
	//System.out.println(replyList.size());
	//最终版本分页查询方法
	QueryHelper queryHelper=new QueryHelper(Reply.class,"r")
	.addCondition("r.topic.id=?",this.topic.getId())
	.addOrderProperty("r.postTime", true);
	PageBean pageBean=this.replyservice.getPageBean(currentPage, pageSize, queryHelper);
	//PageBean pageBean=this.replyservice.getPageBean(currentPage, pageSize, topic);
	ActionContext.getContext().getValueStack().push(pageBean);
	return "show";
	}
}