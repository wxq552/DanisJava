package com.test.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.test.service.productService;
import com.test.util.FileUtil;
import com.test.bean.production;
@Namespace("/admin")
@ParentPackage("struts-default")
@Results({@Result(name="error",location="/error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception="java.lang.NullPointerException",result="error")})
public class productAction {
	
  private production pro;
  private List<production> list;
  private productService productservice;
  private File uploadfile;
  private String uploadfileFileName;
  private int currentPage=1;
  private int pageSize=5;
  private int pageCount;
  private int count;
  private String picadd;
  private String delstr;
  
public String getDelstr() {
	return delstr;
}
public void setDelstr(String delstr) {
	this.delstr = delstr;
}
public String getPicadd() {
	return picadd;
}
public void setPicadd(String picadd) {
	this.picadd = picadd;
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
public File getUploadfile() {
	return uploadfile;
}
public void setUploadfile(File uploadfile) {
	this.uploadfile = uploadfile;
}
public String getUploadfileFileName() {
	return uploadfileFileName;
}
public void setUploadfileFileName(String uploadfileFileName) {
	this.uploadfileFileName = uploadfileFileName;
}
public production getPro() {
	return pro;
}
public void setPro(production pro) {
	this.pro = pro;
}
public List<production> getList() {
	return list;
}
public void setList(List<production> list) {
	this.list = list;
}
public productService getProductservice() {
	return productservice;
}
@Resource
public void setProductservice(productService productservice) {
	this.productservice = productservice;
}

public void setpage(){
	this.count=this.productservice.getProcount();
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

@Action(value="/addproduct",results={@Result(name="addsuc",location="/admin/files/addprosuc.jsp"),
		@Result(name="addfail",location="/admin/files/addprofail.jsp")})
public String addproduct() throws Exception{
	String path=ServletActionContext.getRequest().getRealPath("/upload");
	if(this.getUploadfile()!=null){
		String savename=System.currentTimeMillis()+FileUtil.getFileExt(this.uploadfileFileName);
		this.pro.setPic_addr(savename);
		if(this.productservice.addProduct(this.pro)){
			File saveFile=new File(new File(path),savename);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(this.getUploadfile(), saveFile);
			System.out.println("文件上传成功！");
			return "addsuc";
		}else{
			return "addfail";
		}
	}else{
		return "addfail";
	}
}

@Action(value="/productdetail",results={@Result(name="prodetail",location="/admin/files/00control_product.jsp")})
public String productdetail(){
	setpage();
	this.list=this.productservice.productdetail((currentPage-1)*pageSize,pageSize);
	return "prodetail";
}

@Action(value="/deleteproduct",results={@Result(name="deletesuc",location="/admin/files/deleteprosuc.jsp"),
		@Result(name="deletefail",location="/admin/files/deleteprofail.jsp")})
public String deleteproduct(){
	if(this.productservice.deletepro(this.pro)){
		return "deletesuc";
	}else{
		return "deletefail";
	}
}

@Action(value="/getprodetail",results={@Result(name="oneprodetail",location="/admin/files/00control_product_detial.jsp")})
public String getprodetail(){
	this.pro=this.productservice.getSinglepro(this.pro.getId());
	return "oneprodetail";
}


@Action(value="/modifypro",results={@Result(name="modifypro",location="/admin/files/modifypro.jsp")})
public String modifypro(){
	this.pro=this.productservice.getSinglepro(this.pro.getId());
	return "modifypro";
}

@Action(value="/updateproduct",results={@Result(name="updateprosuc",location="/admin/files/updateprosuc.jsp"),
		@Result(name="updateprofail",location="/admin/files/updateprofail.jsp")})
public String updateproduct() throws Exception{
	String path=ServletActionContext.getRequest().getRealPath("/upload");
	if(this.getUploadfile()==null){
		this.pro.setPic_addr(picadd);
		this.productservice.updateproduct(pro);
		return "updateprosuc";
	}else{
		String savename=System.currentTimeMillis()+FileUtil.getFileExt(this.uploadfileFileName);
		this.pro.setPic_addr(savename);
		if(this.productservice.updateproduct(pro)){
			File saveFile=new File(new File(path),savename);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(this.getUploadfile(), saveFile);
			System.out.println("图片更新成功！");
			return "updateprosuc";
		}else{
			return "updateprofail";
		}
	}
	
}

@Action(value="/deletepromulti",results={@Result(name="deletesuc",location="/admin/files/deleteprosuc.jsp"),
		@Result(name="deletefail",location="/admin/files/deleteprofail.jsp")})
public String deletepromulti(){
	List<production> dellist=new ArrayList<production>();
	String[] delstrarray=this.delstr.split(",");
	for(String delid : delstrarray){
		production p=new production();
		p.setId(Integer.parseInt(delid));
		dellist.add(p);
	}
	if(this.productservice.deleteproductmulti(dellist)){
		return "deletesuc";
	}else{
		return "deletefail";
	}
}
}
