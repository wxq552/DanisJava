package com.test.web;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.msg;
import com.test.service.messageService;

public class messageAction extends ActionSupport{
 private msg mes;
 private messageService messageservice;
public messageService getMessageservice() {
	return messageservice;
}

public void setMessageservice(messageService messageservice) {
	this.messageservice = messageservice;
}

public msg getMes() {
	return mes;
}

public void setMes(msg mes) {
	this.mes = mes;
}
@Action(value="/addmessage",results={@Result(name="addsuc",location="/mes_addsuc.jsp")})
public String addmessage(){
	this.messageservice.addMess(mes);
	return "addsuc";
}
}
