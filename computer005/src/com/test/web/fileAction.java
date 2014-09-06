package com.test.web;

import java.util.List;

import javax.annotation.Resource;
import com.test.bean.picfile;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.annotations.Parameter;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.test.service.picfileService;
@Namespace("/")
@ParentPackage("struts-default")
@Results(@Result(name="error",location="/error.jsp"))
@ExceptionMappings({@ExceptionMapping(exception="java.lang.NullPointerException",result="error")})
public class fileAction extends ActionSupport{
 private picfileService picfileservice;
 private List<picfile> piclist;
 private int currentPage=1;
 private int pageCount;
 private int count;
 private int pageSize=8;
 
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public int getPageCount() {
	return pageCount;
}
public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
}

public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public List<picfile> getPiclist() {
	return piclist;
}
public void setPiclist(List<picfile> piclist) {
	this.piclist = piclist;
}
public picfileService getPicfileservice() {
	return picfileservice;
}
@Resource
public void setPicfileservice(picfileService picfileservice) {
	this.picfileservice = picfileservice;
}

private void setpage(String type){
	this.count=this.picfileservice.getPicCount(type);
	if(this.count%this.pageSize==0){
		this.pageCount=this.count/this.pageSize;
	}else{
		this.pageCount=this.count/this.pageSize+1;
	}
	if(this.currentPage<1){
		this.currentPage=1;
	}
	if(this.currentPage>this.pageCount){
		this.currentPage=this.pageCount;
	}
}


@Action(value="/getglory",results={@Result(name="glorylist",location="/company_glory.jsp")})
public String getglory(){
	setpage("glory");
	this.piclist=this.picfileservice.getpicpage((currentPage-1)*pageSize, pageSize, "glory");
	return "glorylist";
}

@Action(value="/getdevice",results={@Result(name="devicelist",location="/company_product.jsp")})
public String getdevice(){
	setpage("device");
	this.piclist=this.picfileservice.getpicpage((currentPage-1)*pageSize, pageSize, "device");
	return "devicelist";
}

}
