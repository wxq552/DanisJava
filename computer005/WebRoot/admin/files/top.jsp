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
-->
</style>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="59" background="../images/top.gif"><table width="99%" border="0" cellspacing="0" cellpadding="0">
      <tr>
       <!--  <td width="1%"><img src="../images/logo.gif" width="129" height="66" /></td> -->
        <td><img style="margin-left:20px;" src="../images/logo_welcome.gif" ></td>
        <td width="64%" align="right">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
