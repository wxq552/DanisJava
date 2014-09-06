<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Kalirai</title>
<style type="text/css">
<!--
body {
	margin: 0px;
}
.login_img{
  width:"776"; 
  height:"147";
  margin: 0px auto
}

-->
</style>
<link href="${ctx}/admin/css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<form action="checklogin.html" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="${ctx}/admin/images/top02.gif"><img class="login_img"src="${ctx}/admin/images/top03.gif" /></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="${ctx}/admin/images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="${ctx}/admin/images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table></td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">用户名：<br /></td>
        <td width="69%"><input name="adm.username" type="text" size="33" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密码：<br /></td>
        <td><input name="adm.password" type="password" size="33" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">验证码：<br /></td>
        <td><img src="${ctx}/PictureCheckCode.servlet" width="65" id="code" height="30" /> <a href="javascript:;" class="login-text03" onclick="myReload('code')">看不清？换一张</a></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">输入验证码：</td>
        <td><input name="checkcode" type="text" size="30" /></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input type="submit" class="right-button01" value="确定" />
          <input  type="reset" class="right-button01" value="取消" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>

<script type="text/javascript">
 
 function $(id){
	 return document.getElementById(id);
 }
 function myReload(id){
 	var srcstr=$(id).src.substring(0,$(id).src.indexOf("?"));
 	
 	if(srcstr==""){
 		$(id).src=$(id).src+"?nocache="+new Date().getTime();
 	}else{
 		$(id).src=srcstr+"?nocache="+new Date().getTime();
 	}
	
 }
</script>
</body>
</html>