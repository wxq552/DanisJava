package com.test.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.admin;
import com.test.bean.article;
import com.test.bean.job;
import com.test.service.articleService;
import com.test.util.TimeUtil;
@Namespace("/admin")
@ParentPackage("struts-default")
@Results({@Result(name="error",location="/error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception="java.lang.NullPointerException",result="error")})
public class articleAction extends ActionSupport{
  private articleService articleservice;
  private article art=new article();
  private List<article> list;
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
public List<article> getList() {
	return list;
}
public void setList(List<article> list) {
	this.list = list;
}
public article getArt() {
	return art;
}
public void setArt(article art) {
	this.art = art;
}
public articleService getArticleservice() {
	return articleservice;
}
@Resource
public void setArticleservice(articleService articleservice) {
	this.articleservice = articleservice;
}

public void setpage(String type){
    this.count=this.articleservice.getarticlenum(type);
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



@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	return super.execute();
}
@Action(value="/addnews",results={@Result(name="addnewssuc",location="/admin/files/addnewssuc.jsp"),
		                          @Result(name="addnewsfail",location="/admin/files/addnewsfail.jsp")})
public String addnews(){
	admin user=(admin) ServletActionContext.getRequest().getSession().getAttribute("user");
	this.art.setPosttime(TimeUtil.getnow());
	this.art.setType("news");
	this.art.setAuthor(user.getUsername());
	if(this.articleservice.savearticle(art)){
		return "addnewssuc";
		}else{
			return "addnewsfail";
		}
}
@Action(value="/getnewslist",results={@Result(name="newslist",location="/admin/files/00control_news.jsp")})
public String getnewslist(){
	setpage("news");
	this.list=this.articleservice.getnewsPage((currentPage-1)*pageSize, pageSize, "news");
	return "newslist";
}
@Action(value="/getnewsedit",results={@Result(name="artedit",location="/admin/files/modifynews.jsp")})
public String getnewsedit(){
	this.art=this.articleservice.getOneart(art.getId());
	return "artedit";
}

@Action(value="/getnewsdetail",results={@Result(name="artdetail",location="/admin/files/00control_news_detial.jsp")})
public String getnewsdetail(){
	this.art=this.articleservice.getOneart(art.getId());
	return "artdetail";
}

@Action(value="/updatenews",results={@Result(name="updatenewssuc",location="/admin/files/updatenewssuc.jsp"),
		@Result(name="updatenewsfail",location="/admin/files/updatenewsfail.jsp")})
public String updatenews(){
	this.art.setType("news");
	this.art.setPosttime(TimeUtil.getnow());
	if(this.articleservice.updateArt(art)){
	return "updatenewssuc";	
	}else{
	return "updatenewsfail";
	}
}
@Action(value="/deletenews",results={@Result(name="deletenewssuc",location="/admin/files/deletenewssuc.jsp"),
		@Result(name="deletenewsfail",location="/admin/files/deletenewsfail.jsp")})
public String deletenews(){
    if(this.articleservice.deleteArt(art)){
    return "deletenewssuc";	
    }else{
    return "deletenewsfail";
    }
}
@Action(value="/deletenewsmulti",results={@Result(name="deletenewssuc",location="/admin/files/deletenewssuc.jsp"),
		@Result(name="deletenewsfail",location="/admin/files/deletenewsfail.jsp")})
public String deletenewsmulti(){
	List<article> delist=new ArrayList<article>();
	if(this.delstr.equals("")){
		return "deletenewsfail";
	}
	String[] strarray=this.delstr.split(",");
	for(String str : strarray){
		article j=new article();
		j.setId(Integer.parseInt(str));
		delist.add(j);
	}	
	if(this.articleservice.delartMulti(delist)){
		return "deletenewssuc";
	}else{
		return "deletenewsfail";
	}
}
@Action(value="/addpack",results={@Result(name="addpacksuc",location="/admin/files/addpacksuc.jsp"),
		@Result(name="addpackfail",location="/admin/files/addpackfail.jsp")})
public String addpack(){
	admin user=(admin) ServletActionContext.getRequest().getSession().getAttribute("user");
	this.art.setPosttime(TimeUtil.getnow());
	this.art.setType("pack");
	this.art.setAuthor(user.getUsername());
	if(this.articleservice.savearticle(art)){
		return "addpacksuc";
	}else{
		return "addpackfail";
	}
}
@Action(value="/getpacklist",results={@Result(name="packlist",location="/admin/files/00control_knowledge.jsp")})
public String getpacklist(){
	setpage("pack");
	this.list=this.articleservice.getnewsPage((currentPage-1)*pageSize, pageSize,"pack");
	return "packlist";
}
@Action(value="/deletepack",results={@Result(name="deletepacksuc",location="/admin/files/deletepacksuc.jsp"),
		@Result(name="deletepackfail",location="/admin/files/deletepackfail.jsp")})
public String deletepack(){
	if(this.articleservice.deleteArt(art)){
		return "deletepacksuc";
	}else{
		return "deletepackfail";
	}
}
@Action(value="/getpackedit",results={@Result(name="getpackedit",location="/admin/files/modifypack.jsp")})
public String getpackedit(){
	this.art=this.articleservice.getOneart(art.getId());
	return "getpackedit";
}
@Action(value="/getpackdetail",results={@Result(name="getpackdetail",location="/admin/files/00control_knowledge_detial.jsp")})
public String getpackdetail(){
	this.art=this.articleservice.getOneart(art.getId());
	return "getpackdetail";
}
@Action(value="/updatepack",results={@Result(name="updatepacksuc",location="/admin/files/updatepacksuc.jsp"),
		@Result(name="updatepackfail",location="/admin/files/updatepackfail.jsp")})
public String updatepack(){
	this.art.setPosttime(TimeUtil.getnow());
	this.art.setType("pack");
	if(this.articleservice.updateArt(art)){
		return "updatepacksuc";
	}else{
		return "updatepackfail";
	}
}

@Action(value="/deletepackmulti",results={@Result(name="deletepacksuc",location="/admin/files/deletepacksuc.jsp"),
		@Result(name="deletepackfail",location="/admin/files/deletepackfail.jsp")})
public String deletepackmulti(){
	List<article> delist=new ArrayList<article>();
	if(this.delstr.equals("")){
		return "deletepackfail";
	}
	String[] strarray=this.delstr.split(",");
	for(String str : strarray){
		article j=new article();
		j.setId(Integer.parseInt(str));
		delist.add(j);
	}	
	if(this.articleservice.delartMulti(delist)){
		return "deletepacksuc";
	}else{
		return "deletepackfail";
	}
}
}
