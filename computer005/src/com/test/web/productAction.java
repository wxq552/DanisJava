package com.test.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.production;
import com.test.service.productService;

public class productAction extends ActionSupport{
  private productService productservice;
  private List<production> list;
  private production pro;
  private int currentPage=1;
  private int pageCount;
  private int count;
  private int pageSize=8;
  private String type;
  
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public production getPro() {
	return pro;
}
public void setPro(production pro) {
	this.pro = pro;
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
public productService getProductservice() {
	return productservice;
}
@Resource
public void setProductservice(productService productservice) {
	this.productservice = productservice;
}
public List<production> getList() {
	return list;
}
public void setList(List<production> list) {
	this.list = list;
}
 
private void setpage(String type){
	this.count=this.productservice.getprocountByType(type);
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
@Action(value="/product_type",results={@Result(name="protype",location="/product_type.jsp")})
public String product_type() throws Exception{
	this.type=new String(this.pro.getType().getBytes("iso-8859-1"),"UTF-8");
	System.out.println(this.type);
	setpage(this.type);
	this.list=this.productservice.getPageProType((currentPage-1)*pageSize, pageSize, this.type);
	for(production p : list){
		System.out.println(p.getPic_addr());
	}
	return "protype";
}
@Action(value="/product_detail",results={@Result(name="prodetail",location="/product_detial.jsp")})
public String product_detail(){
	this.pro=this.productservice.getSinglepro(this.pro.getId());
	return "prodetail";
}
}
