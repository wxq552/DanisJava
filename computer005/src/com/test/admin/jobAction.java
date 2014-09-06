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
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.job;
import com.test.bean.msg;
import com.test.service.jobService;
@Namespace("/admin")
@ParentPackage("struts-default")
@Results({@Result(name="error",location="/error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception="java.lang.NullPointerException",result="error")})
public class jobAction extends ActionSupport{
 private jobService jobservice;
 private job job;
 private int currentPage=1;
 private int pageSize=5;
 private int pageCount;
 private int count;
 private String delstr;
 
 public String getDelstr() {
	return delstr;
}
public void setDelstr(String delstr) {
	this.delstr = delstr;
}

private List<job> list;

public List<job> getList() {
	return list;
}
public void setList(List<job> list) {
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
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public job getJob() {
	return job;
}
public void setJob(job job) {
	this.job = job;
}
public jobService getJobservice() {
	return jobservice;
}
@Resource
public void setJobservice(jobService jobservice) {
	this.jobservice = jobservice;
}
@Action(value="/addjob",results={@Result(name="addsuc",location="/admin/files/addsuc.jsp"),
		                             @Result(name="input",location="/admin/files/addfail.jsp")})
public String addjob(){
	System.out.println(this.job.getJob_name());
	if(this.jobservice.saveJob(this.job)){
		return "addsuc";
	}else{
        return "input";
	}
}

public void setpage(){
    this.count=this.jobservice.getjobCount();
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
@Action(value="/getjoblist",results={@Result(name="joblist",location="/admin/files/00control_jobs.jsp")})
public String getjoblist(){
	setpage();
	this.list=this.jobservice.getpagejob((currentPage-1)*pageSize, pageSize);
	return "joblist";
}
@Action(value="/deletejob",results={@Result(name="deljobsuc",location="/admin/files/deljobsuc.jsp"),
		                            @Result(name="deljobfail",location="/admin/files/deljobfail.jsp")})
public String deletejob(){
	if(this.jobservice.deleteonejob(this.job)){
		return "deljobsuc";
	}else{
		return "deljobfail";
	}
}
@Action(value="/getjobdetail",results={@Result(name="jobdetail",location="/admin/files/00control_jobs_detial.jsp")})
public String getjobdetail(){
	this.job=this.jobservice.getonejob(job.getId());
	return "jobdetail";
}
@Action(value="/modifyjob",results={@Result(name="modify",location="/admin/files/job_modify.jsp")})
public String modifyjob(){
	this.job=this.jobservice.getonejob(job.getId());
	return "modify";
}
@Action(value="/updatejob",results={@Result(name="updatesuc",location="/admin/files/updatesuc.jsp"),
		                            @Result(name="updatefail",location="/admin/files/updatefail.jsp")})
public String updatejob(){
	if(this.jobservice.updateJob(this.job)){
		return "updatesuc";
	}else{
		return "updatefail";
	}
}
@Action(value="/deletemulti",results={@Result(name="deljobsuc",location="/admin/files/deljobsuc.jsp"),
		                              @Result(name="deljobfail",location="/admin/files/deljobfail.jsp")})
public String deletemulti(){
	List<job> delist=new ArrayList<job>();
	if(this.delstr.equals("")){
		return "deljobfail";
	}
	String[] strarray=this.delstr.split(",");
	for(String str : strarray){
		job j=new job();
		j.setId(Integer.parseInt(str));
		delist.add(j);
	}
	if(this.jobservice.deletejobmulti(delist)){
		return "deljobsuc";
	}else{
		return "deljobfail";
	}
}
}
