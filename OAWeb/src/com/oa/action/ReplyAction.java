package com.oa.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.base.BaseAction;
import com.oa.bean.Reply;
import com.oa.bean.Topic;
import com.oa.bean.User;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
@Namespace("/")
public class ReplyAction extends BaseAction{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  private Reply reply;
  private Topic topic;
  private Long id;
  
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

public Reply getReply() {
	return reply;
}

public void setReply(Reply reply) {
	this.reply = reply;
}
/**
 * 转发到回复页面
 * @return
 */
@Action(value="reply_addUI",results={@Result(name="toaddUI",location="/WEB-INF/jsp/replyAction/addUI.jsp")})
public String reply_addUI(){
	//准备回显数据
	this.topic=this.topicservice.getById(this.topic.getId());
	return "toaddUI";
}
/**
 * 添加回复
 * @return
 */
@Action(value="reply_add",results={@Result(name="show",type="redirectAction",params={"actionName","topic_show.htm","id","%{id}"})})
public String reply_add(){
	User author=(User) ActionContext.getContext().getSession().get("user");
	this.topic =this.topicservice.getById(this.topic.getId());
	this.id=this.topic.getId();
	this.reply.setAuthor(author);
	this.reply.setPostTime(new Date());
	this.reply.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
	this.reply.setTopic(topic);
	this.replyservice.addReply(this.reply);
	return "show";
}
}