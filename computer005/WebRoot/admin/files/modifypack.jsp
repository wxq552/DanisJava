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
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />


<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="updatepack.html?art.id=${art.id}" method="post" enctype="multipart/form-data" name="form" target="mainFrame" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >包装常识添加版面</th>
  </tr>
  
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr>
			<td align="left">
		  
	     	</td>
		</tr>
	
			
		<TR id="zdjh">
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>包装常识</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="5%">标题:</td>
					    <td ><input name='art.title' type="text" class="text" style="width:50%" value="${art.title}" />
				        
					  
					  </tr>
					
					  <tr>
					    <td align="right">内容描述:</td>
					    <td colspan="3"><textarea name="art.content" cols="80" rows="20" style="width:100%">${art.content}</textarea></td>
					    </tr>
					  </table>
			  <br />
				</fieldset>
				</TD>
		</TR>
	
		</TABLE>
	
	
	 </td>
  </tr>
  
  
		
	
		<TR>
			<TD colspan="2" align="center" height="50px">
				<input type="submit" name="Submit" value="添加" class="button1" />
			
			
			<input type="reset" name="Submit2" value="重置" class="button1"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
