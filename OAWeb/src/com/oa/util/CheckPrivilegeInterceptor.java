package com.oa.util;

import com.oa.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 自定义拦截器，拦截检查用户是否登录或有权限访问请求
 * @author Administrator
 *
 */
public class CheckPrivilegeInterceptor extends AbstractInterceptor{
    
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
//	    System.out.println("拦截action之前--------》");
//	    String result=invocation.invoke();//放行
//	    System.out.println("拦截action之后--------》");
//		return result;
		
		User user=(User) ActionContext.getContext().getSession().get("user");
		String namespace=invocation.getProxy().getNamespace();
        String actionName=invocation.getProxy().getActionName();
        String privUrl=namespace+actionName;
        //System.out.println(privUrl);
		// 如果未登录
		if (user == null) {
			if (privUrl.startsWith("/user_login")) { // "/user_loginUI", "/user_login"
				// 如果是去登录，就放行
				return invocation.invoke();
			} else {
				// 如果不是去登录，就转到登录页面
				return "loginUI";
			}
		}
		// 如果已登 录，就判断权限
		else {
			if (user.hasPrivilegeByUrl(privUrl)) {
				// 如果有权限，就放行
				return invocation.invoke();
			} else {
				// 如果没有权限，就转到提示页面
				return "noPrivilegeError";
			}
		}
	}

}