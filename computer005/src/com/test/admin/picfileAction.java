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

import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.picfile;
import com.test.service.picfileService;
import com.test.util.FileUtil;
@Namespace("/admin")
@ParentPackage("struts-default")
@Results({@Result(name="error",location="/error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception="java.lang.NullPointerException",result="error")})
public class picfileAction extends ActionSupport{
    private picfileService picfileservice;
    private picfile picfile;
    private File uploadfile;
    private String uploadfileFileName;
    private int currentPage=1;
    private int pageSize=5;
    private int count;
    private int pageCount;
    private List<picfile> list;
    private String delstr;
	public String getDelstr() {
		return delstr;
	}
	public void setDelstr(String delstr) {
		this.delstr = delstr;
	}
	public List<picfile> getList() {
		return list;
	}
	public void setList(List<picfile> list) {
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
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
	public picfile getPicfile() {
		return picfile;
	}
	public void setPicfile(picfile picfile) {
		this.picfile = picfile;
	}
	public picfileService getPicfileservice() {
		return picfileservice;
	}
	@Resource
	public void setPicfileservice(picfileService picfileservice) {
		this.picfileservice = picfileservice;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
@Action(value="/addgolory",results={@Result(name="addsuc",location="/admin/files/addpicsuc.jsp"),
		@Result(name="addfail",location="/admin/files/addpicfail.jsp")})
   public String addgolory() throws Exception{
	String path=ServletActionContext.getRequest().getRealPath("/upload");
	  if(this.getUploadfile()!=null){
		  this.picfile.setPicname(this.uploadfileFileName);
		  String savename=System.currentTimeMillis()+FileUtil.getFileExt(this.uploadfileFileName);
		  this.picfile.setSavename(savename);
		  this.picfile.setPic_address("/"+savename);
		  this.picfile.setType("glory");
		  if(this.picfileservice.savePic(this.picfile)){
			  File saveFile=new File(new File(path),savename);
				if(!saveFile.getParentFile().exists()){
					saveFile.getParentFile().mkdirs();
				}
				FileUtils.copyFile(this.getUploadfile(), saveFile);
				System.out.println("图片上传成功！");
				return "addsuc";
		  }else{
			  return "addfail";
		  }
	  }else{
		  return "addfail";
	  }
	  
   }

@Action(value="/adddevice",results={@Result(name="addsuc",location="/admin/files/adddevsuc.jsp"),
		@Result(name="addfail",location="/admin/files/adddevfail.jsp")})
   public String adddevice() throws Exception{
	String path=ServletActionContext.getRequest().getRealPath("/upload");
	  if(this.getUploadfile()!=null){
		  this.picfile.setPicname(this.uploadfileFileName);
		  String savename=System.currentTimeMillis()+FileUtil.getFileExt(this.uploadfileFileName);
		  this.picfile.setSavename(savename);
		  this.picfile.setPic_address("/"+savename);
		  this.picfile.setType("device");
		  if(this.picfileservice.savePic(this.picfile)){
			  File saveFile=new File(new File(path),savename);
				if(!saveFile.getParentFile().exists()){
					saveFile.getParentFile().mkdirs();
				}
				FileUtils.copyFile(this.getUploadfile(), saveFile);
				System.out.println("图片上传成功！");
				return "addsuc";
		  }else{
			  return "addfail";
		  }
	  }else{
		  return "addfail";
	  }
	  
   }
public void setpage(String type){
	count=this.picfileservice.getPicCount(type);
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
@Action(value="/glorylist",results={@Result(name="glorylist",location="/admin/files/00control_glory.jsp")})
public String glorylist(){
	setpage("glory");
	this.list=this.picfileservice.getpicpage((currentPage-1)*pageSize,5,"glory");
	return "glorylist";
}

@Action(value="/devlist",results={@Result(name="devlist",location="/admin/files/00control_product0.jsp")})
public String devlist(){
	setpage("device");
	this.list=this.picfileservice.getpicpage((currentPage-1)*pageSize,5,"device");
	return "devlist";
}

@Action(value="/deletepicmulti",results={@Result(name="delsuc",location="/admin/files/delpicsuc.jsp"),
		@Result(name="delfail",location="/admin/files/delpicfail.jsp")})
public String deletepicmulti(){
   	String[] delstrs=this.delstr.split(",");
   	List<picfile> dellist=new ArrayList<picfile>();
   	for(String strid : delstrs){
   		picfile p=new picfile();
   		p.setId(Integer.parseInt(strid));
   		dellist.add(p);
   	}
   	if(this.picfileservice.delMultipic(dellist)){
   		return "delsuc";
   	}else{
   		return "delfail";
   	}
}

@Action(value="/deletedevmulti",results={@Result(name="delsuc",location="/admin/files/deldevsuc.jsp"),
		@Result(name="delfail",location="/admin/files/deldevfail.jsp")})
public String deletedevmulti(){
   	String[] delstrs=this.delstr.split(",");
   	List<picfile> dellist=new ArrayList<picfile>();
   	for(String strid : delstrs){
   		picfile p=new picfile();
   		p.setId(Integer.parseInt(strid));
   		dellist.add(p);
   	}
   	if(this.picfileservice.delMultipic(dellist)){
   		return "delsuc";
   	}else{
   		return "delfail";
   	}
}
@Action(value="/delpic",results={@Result(name="delsuc",location="/admin/files/delpicsuc.jsp"),
		@Result(name="delfail",location="/admin/files/delpicfail.jsp")})
public String delpic(){
	if(this.picfileservice.delSinglePic(this.picfile)){
		return "delsuc";
	}else{
		return "delfail";
	}
}

@Action(value="/deldev",results={@Result(name="delsuc",location="/admin/files/deldevsuc.jsp"),
		@Result(name="delfail",location="/admin/files/deldevfail.jsp")})
public String deldev(){
	if(this.picfileservice.delSinglePic(this.picfile)){
		return "delsuc";
	}else{
		return "delfail";
	}
}

@Action(value="/modifypic",results={@Result(name="modifypic",location="/admin/files/modifypic.jsp"),
		@Result(name="modifydev",location="/admin/files/modifydev.jsp")})
public String modifypic(){
	this.picfile=this.picfileservice.getSinglePic(this.picfile.getId());
	if(this.picfile.getType().equals("glory")){
		return "modifypic";
	}else{
		return "modifydev";
	}
	
	
}

@Action(value="/updatepicfile",results={@Result(name="modifysuc",location="/admin/files/modifyglorysuc.jsp"),
		@Result(name="modifyfail",location="/admin/files/modifygloryfail.jsp"),
		@Result(name="modifysuc1",location="/admin/files/modifydevsuc.jsp"),
		@Result(name="modifyfail1",location="/admin/files/modifydevfail.jsp")})
public String updatepicfile() throws Exception{
	String path=ServletActionContext.getRequest().getRealPath("/upload");
	picfile p=this.picfileservice.getSinglePic(this.picfile.getId());
	if(this.getUploadfile()==null){
		this.picfile.setPicname(p.getPicname());
		this.picfile.setSavename(p.getSavename());
		this.picfile.setPic_address(p.getPic_address());
		this.picfile.setType(p.getType());
		if(this.picfileservice.UpdateSinglePic(this.picfile)){
			if(p.getType().equals("glory")){
				return "modifysuc";
			}else{
				return "modifysuc1";
			}
			
		}else{
			if(p.getType().equals("glory")){
				return "modifyfail";
			}else{
				return "modifyfail1";
			}
			
		}
	}else{
		  this.picfile.setPicname(this.uploadfileFileName);
		  String savename=System.currentTimeMillis()+FileUtil.getFileExt(this.uploadfileFileName);
		  this.picfile.setSavename(savename);
		  this.picfile.setPic_address("/"+savename);
		  this.picfile.setType(p.getType());
		  if(this.picfileservice.UpdateSinglePic(this.picfile)){
			  File saveFile=new File(new File(path),savename);
				if(!saveFile.getParentFile().exists()){
					saveFile.getParentFile().mkdirs();
				}
				FileUtils.copyFile(this.getUploadfile(), saveFile);
				System.out.println("图片更新成功！");	
				if(p.getType().equals("glory")){
					return "modifysuc";
				}else{
					return "modifysuc1";
				}
	}else{
		if(p.getType().equals("glory")){
			return "modifyfail";
		}else{
			return "modifyfail1";
		}
	}
}
}
@Action(value="/picdetail",results={@Result(name="glorydetail",location="/admin/files/00control_glory_detial.jsp"),
		@Result(name="devicedetail",location="/admin/files/00control_device_detial.jsp")})
public String picdetail(){
	this.picfile=this.picfileservice.getSinglePic(picfile.getId());
	if(this.picfile.getType().equals("glory")){
		return "glorydetail";
	}else{
		return "devicedetail";
	}
}



}
