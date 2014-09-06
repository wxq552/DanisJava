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
  <form action="updatejob.html?job.id=${job.id}" method="post"  name="form" target="mainFrame" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >人才招聘编辑版面</th>
  </tr>
  
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
	
			
		<TR id="zdjh">
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>人才招聘信息一</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td >招聘单位:</td>
					    <td colspan="3"><input name="job.unit" width="25%" type="text" value="${job.unit}" /></td>
					    <td align="right">工作地点:</td>
					    <td colspan="3"><input name="job.place" width="25%" type="text" value="${job.place}" /></td>
					    <td align="right">招聘人数:</td>
					    <td colspan="3"><input name="job.num" width="25%" type="text" value="${job.num}" /></td>
					   
					  </tr>
					  <tr>
					    <td >职业名称:</td>
					    <td colspan="3"><input name="job.job_name" width="25%" type="text" value="${job.job_name}" /></td>
					    <td align="right">职业类型:</td>
					    <td colspan="3"><input name="job.job_type" width="25%" type="text" value="${job.job_type}"/></td>
					    <td align="right">工作经验:</td>
					    <td colspan="3"><input name="job.experience" width="25%" type="text" value="${job.experience}" /></td>
					  </tr>
					  <tr>
					    <td >学历时间:</td>
					    <td colspan="3"><input name="job.quality" width="25%" type="text" value="${job.quality}"/></td>
					    <td align="right">发布时间:</td>
					    <td colspan="3"><input name="job.post_time" width="25%" type="text" value="${job.post_time}" /></td>
					  </tr>
					
					    <tr>
					    <td align="right">职位描述:</td>
					    <td colspan="3"><textarea name="job.description" cols="50" rows="10" >${job.description}</textarea></td>
					    <td align="right">招聘要求:</td>
					    <td colspan="3"><textarea name="job.requirement" cols="50" rows="10">${job.requirement}</textarea></td>
					  </tr> 
					  <tr>
					    <td >联系人:</td>
					    <td colspan="3"><input name="job.contactor" width="25%" type="text" value="${job.contactor}" /></td>
					    <td align="right">联系电话:</td>
					    <td colspan="3"><input name="job.phone" width="25%" type="text" value="${job.phone}" /></td>
					    <td align="right">联系邮箱:</td>
					    <td colspan="3"><input name="job.email" width="25%" type="text" value="${job.email}"/>
					    </td>
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
