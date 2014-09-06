package com.oa.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.base.BaseAction;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Namespace("/")
public class HomeAction extends BaseAction{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Action(value="home_index",results={@Result(name="index",location="/WEB-INF/jsp/homeAction/index.jsp")})    
	public String home_index(){
	   return "index";
   }
    
    @Action(value="home_top",results={@Result(name="top",location="/WEB-INF/jsp/homeAction/top.jsp")})    
	public String home_top(){
	   return "top";
   }
    
    @Action(value="home_bottom",results={@Result(name="bottom",location="/WEB-INF/jsp/homeAction/bottom.jsp")})    
	public String home_bottom(){
	   return "bottom";
   }
    
    @Action(value="home_left",results={@Result(name="left",location="/WEB-INF/jsp/homeAction/left.jsp")})    
	public String home_left(){
	   return "left";
   }
    @Action(value="home_right",results={@Result(name="right",location="/WEB-INF/jsp/homeAction/right.jsp")})    
	public String home_right(){
	   return "right";
   }
}