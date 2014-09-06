package com.test.admin;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
import com.test.bean.admin;
import com.test.bean.msg;
import com.test.bean.surface;
import com.test.service.adminService;
import com.test.util.FileUtil;
@Namespace("/admin")
@ParentPackage("struts-default")
@Results({@Result(name="error",location="/error.jsp")})
@ExceptionMappings({@ExceptionMapping(exception="java.lang.NullPointerException",result="error")})
public class adminAction extends ActionSupport{
  private adminService adminservice;
  private admin adm;
  private String checkcode;
  private File uploadfile;
  private String uploadfileFileName;
  private msg msg;
  public msg getMsg() {
	return msg;
}
public void setMsg(msg msg) {
	this.msg = msg;
}

private surface sur=new surface();

public surface getSur() {
	return sur;
}
public void setSur(surface sur) {
	this.sur = sur;
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
public String getCheckcode() {
	return checkcode;
}
public void setCheckcode(String checkcode) {
	this.checkcode = checkcode;
}
public admin getAdm() {
	return adm;
}
public void setAdm(admin adm) {
	this.adm = adm;
}
public adminService getAdminservice() {
	return adminservice;
}
@Resource
public void setAdminservice(adminService adminservice) {
	this.adminservice = adminservice;
}
@Override
public String execute() throws Exception {
	
	return null;
}

@Action(value="/checklogin",results={@Result(name="loginsuc",location="/admin/index.jsp"),
		                             @Result(name="login",location="/admin/login.jsp")})
public String checklogin(){
	
	    HttpSession session=ServletActionContext.getRequest().getSession();
		
		if(session.getAttribute("user")!=null){
			return "loginsuc";
		}else{
			admin per=this.adminservice.getone(this.adm.getUsername());
			if(session.getAttribute("rand").toString().toLowerCase().equals(checkcode)){
		     	if(per!=null){
				  if(per.getPassword().equals(this.adm.getPassword())){
					session.setAttribute("user",per);
					return "loginsuc";
				}else{
					return "login";
				}
			}else{
				return "login";
			}
		}else{
			return "login";
		}

		}
     	
}
@Action(value="/logout",results={@Result(name="login",location="/admin/login.jsp")})
public String logout(){
	HttpSession session=ServletActionContext.getRequest().getSession();
	if(session.getAttribute("user")!=null){
		session.removeAttribute("user");
		return "login";
	}else{
		return "login";
	}
}
@Action(value="/uploadbigimg",results={@Result(name="uploadsuc",location="/admin/files/uploadsuc.jsp"),
		                               @Result(name="uploaderr",location="/admin/files/uploaderr.jsp")})
public String uploadbigimg() throws Exception{
	String path=ServletActionContext.getRequest().getRealPath("/upload");
	
	if(this.getUploadfile()!=null){
		//System.out.println(this.uploadfileFileName);
		String savename=System.currentTimeMillis()+FileUtil.getFileExt(this.uploadfileFileName);
		//this.uploadfileFileName=savename;
		//System.out.println(savename);
		this.sur.setPic_address("/"+savename);
		if(this.adminservice.savefileinfo(this.sur)){
			File saveFile=new File(new File(path),savename);
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(this.getUploadfile(), saveFile);
			System.out.println("大图上传成功！");
			return "uploadsuc";
		}else{
			return "uploaderr"; 
		}
		
	}else{
		return null;
	}
	
}

}
