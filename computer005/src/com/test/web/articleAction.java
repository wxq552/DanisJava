package com.test.web;

import java.util.List;

import javax.annotation.Resource;

import com.test.bean.article;
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
import com.test.service.picfileService;
@Namespace("/")
@ParentPackage("struts-default")
@Results(@Result(name="error",location="/error.jsp"))
@ExceptionMappings({@ExceptionMapping(exception="java.lang.NullPointerException",result="error")})
public class articleAction extends ActionSupport{
 private articleService articleservice;
 private List<article> artlist;
 private int currentPage=1;
 private int pageCount;
 private int count;
 private int pageSize=10;
 private article art;
public article getArt() {
	return art;
}
public void setArt(article art) {
	this.art = art;
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

public articleService getArticleservice() {
	return articleservice;
}
@Resource
public void setArticleservice(articleService articleservice) {
	this.articleservice = articleservice;
}
public List<article> getArtlist() {
	return artlist;
}
public void setArtlist(List<article> artlist) {
	this.artlist = artlist;
}
private void setpage(String type){
	this.count=this.articleservice.getarticlenum(type);
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


@Action(value="/new",results={@Result(name="newslist",location="/new.jsp")})
public String getnews(){
	setpage("news");
	this.artlist=this.articleservice.getnewsPage((currentPage-1)*pageSize, pageSize, "news");
	return "newslist";
}

@Action(value="/packing",results={@Result(name="packlist",location="/packing.jsp")})
public String getpacking(){
	setpage("pack");
	this.artlist=this.articleservice.getnewsPage((currentPage-1)*pageSize, pageSize, "pack");
	return "packlist";
}
@Action(value="/article_detail",results={@Result(name="artdetail",location="/article.jsp")})
public String artdetail(){
	this.art=this.articleservice.getOneart(this.art.getId());
	this.art.setCount(this.art.getCount()+1);
	this.articleservice.updateArt(art);
	return "artdetail";
}
}
