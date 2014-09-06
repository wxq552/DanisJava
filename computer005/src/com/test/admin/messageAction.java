package com.test.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import com.opensymphony.xwork2.ActionSupport;
import com.test.service.messageService;
import com.test.bean.*;
@Namespace("/admin")
@ParentPackage("struts-default")
@Results({@Result(name="error",location="/error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception="java.lang.NullPointerException",result="error")})
public class messageAction extends ActionSupport{
  private messageService messageservice;
  private int currentPage=1;
  private int pageSize=5;
  private int pageCount;
  private List<msg> list;
  private msg msg;
  private int count;
  private String delstr;
  

public String getDelstr() {
	return delstr;
}
public void setDelstr(String delstr) {
	this.delstr = delstr;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public msg getMsg() {
	return msg;
}
public void setMsg(msg msg) {
	this.msg = msg;
}
public List<msg> getList() {
	return list;
}
public void setList(List<msg> list) {
	this.list = list;
}
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
public int getPageCount() {
	return pageCount;
}
public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
}

public messageService getMessageservice() {
	return messageservice;
}
@Resource
public void setMessageservice(messageService messageservice) {
	this.messageservice = messageservice;
}
@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	return super.execute();
}

public void setpage(){
    this.count=this.messageservice.getcount();
	if(this.count%pageSize==0){
		this.pageCount=this.count/pageSize;
	}else{
		this.pageCount=this.count/pageSize+1;
	}
	if(this.currentPage<1){
		this.currentPage=1;
	}
	if(this.currentPage>this.pageCount){
		this.currentPage=this.pageCount;
	}
}

@Action(value="/getmessagepage",results={@Result(name="msglist",location="/admin/files/00control_message.jsp")})
public String getmessagepage(){
	setpage();
	this.list=this.messageservice.getmessages((this.currentPage-1)*pageSize, pageSize);
	return "msglist";
}
@Action(value="/deletemsg",results={@Result(name="deletesuc",location="/admin/files/msgdeletesuc.jsp"),
		                            @Result(name="deletefail",location="/admin/files/msgdeletefail.jsp")})
public String deletemsg(){
	if(this.messageservice.deleteone(msg)){
		return "deletesuc";
	}else{
		return "deletefail";
	     
	}
}
@Action(value="/deletemsgmulti",results={@Result(name="deletesuc",location="/admin/files/msgdeletesuc.jsp"),
		                              @Result(name="deletefail",location="/admin/files/msgdeletefail.jsp")})
public String deletemulti(){
	List<msg> delist=new ArrayList<msg>();
	if(this.delstr.equals("")){
		return "deletefail";
	}
	String[] strarray=this.delstr.split(",");
	for(String str : strarray){
		msg m=new msg();
		m.setId(Integer.parseInt(str));
		delist.add(m);
	}
	if(this.messageservice.deleteMulti(delist)){
	   return "deletesuc";
	}else{
		return "deletefail";
	}
}
@Action(value="/getmsgdetail",results={@Result(name="msgdetail",location="/admin/files/00control_message_detial.jsp")})
public String getmsgdetail(){
	this.msg=this.messageservice.getonebean(msg.getId());
	return "msgdetail";
}

}
