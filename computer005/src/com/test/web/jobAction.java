package com.test.web;

import java.util.List;

import javax.annotation.Resource;

import com.test.bean.article;
import com.test.bean.job;
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
import com.test.service.articleService;
import com.test.service.jobService;
import com.test.service.picfileService;
@Namespace("/")
@ParentPackage("struts-default")
@Results(@Result(name="error",location="/error.jsp"))
@ExceptionMappings({@ExceptionMapping(exception="java.lang.NullPointerException",result="error")})
public class jobAction extends ActionSupport{
 private jobService jobservice;
 private List<job> joblist;
 private int currentPage=1;
 private int pageCount;
 private int count;
 private int pageSize=10;
 private job job;
 
public job getJob() {
	return job;
}
public void setJob(job job) {
	this.job = job;
}
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

public jobService getJobservice() {
	return jobservice;
}
@Resource
public void setJobservice(jobService jobservice) {
	this.jobservice = jobservice;
}
public List<job> getJoblist() {
	return joblist;
}
public void setJoblist(List<job> joblist) {
	this.joblist = joblist;
}
private void setpage(){
	this.count=this.jobservice.getjobCount();
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


@Action(value="/jobs",results={@Result(name="jobslist",location="/jobs.jsp")})
public String getjobs(){
	setpage();
	this.joblist=this.jobservice.getpagejob((currentPage-1)*pageSize, pageSize);
	return "jobslist";
}
@Action(value="/jobs_detial",results={@Result(name="jobdetail",location="/jobs_detial.jsp")})
public String jobs_detial(){
	this.job=this.jobservice.getonejob(this.job.getId());
	return "jobdetail";
}
}
