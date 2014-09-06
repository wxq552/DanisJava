package com.test.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import com.test.bean.*;
import com.opensymphony.xwork2.ActionSupport;
import com.test.service.productService;
import com.test.service.surfaceService;
@Namespace("/")
@ParentPackage("struts-default")
@Results(@Result(name="error",location="/error.jsp"))
@ExceptionMappings({@ExceptionMapping(exception="java.lang.NullPointerException",result="error")})
public class indexAction extends ActionSupport{
 private surfaceService surfaceservice;
 private productService productservice;


public productService getProductservice() {
	return productservice;
}
@Resource
public void setProductservice(productService productservice) {
	this.productservice = productservice;
}
public surfaceService getSurfaceservice() {
	return surfaceservice;
}
@Resource
public void setSurfaceservice(surfaceService surfaceservice) {
	this.surfaceservice = surfaceservice;
}
@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	return super.execute();
}
@Action(value="/surface",results={@Result(name="success",location="/index.jsp")})//redirect是普通页面转发，没有伴随着值栈数据的转发
public String getsurfaces(){
	HttpSession session=ServletActionContext.getRequest().getSession();
	List<surface> surfaces=this.surfaceservice.getallimg();
	List <String> types=this.productservice.findProduct();
	session.setAttribute("surfaces", surfaces);
	session.setAttribute("types", types);
	return SUCCESS;
}
}
