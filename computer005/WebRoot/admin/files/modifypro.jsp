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
  <form action="updateproduct.html?picadd=${pro.pic_addr}&pro.id=${pro.id}" method="post" enctype="multipart/form-data" name="form" target="mainFrame" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >产品展示添加版面</th>
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
				<legend>产品展示</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="15%">产品图片:</td>
					    <td width="35%"> <input name='uploadfile' type="file"  style="width:154px" /></td>
					  
					  </tr>
					
					  <tr>
					    <td align="right">产品名称:</td>
					    <td colspan="3"><textarea name="pro.name" cols="50" rows="1">${pro.name}</textarea></td>
					    <td align="right">产品类别:</td>
					    <td colspan="3"><textarea name="pro.type" cols="50" rows="1">${pro.type}</textarea></td>
					    </tr>
					     <tr>
					    <td align="right">产品型号:</td>
					    <td colspan="3"><textarea name="pro.xinghao" cols="50" rows="1">${pro.xinghao}</textarea></td>
					   
					    </tr>
					    <tr>
					    <td align="right">产品描述:</td>
					    <td colspan="3"><textarea name="pro.description" cols="50" rows="10">${pro.description}</textarea></td>
					    <td align="right">产品介绍:</td>
					    <td colspan="3"><textarea name="pro.intro" cols="50" rows="10">${pro.intro}</textarea></td>
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
			
			
			<input type="reset" name="Submit2" value="重置" class="button1" /></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
