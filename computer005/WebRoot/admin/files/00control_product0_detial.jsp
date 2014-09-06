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
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "ËÎÌå";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "ËÎÌå";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "ËÎÌå";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "ËÎÌå";
	font-size: 14px;
	height: 37px;
}
.control_glory_detial{
	width: 200px;
	height: 200px;
	margin: 0px auto
}
.p_button{
	margin: 0px auto;
	width:100px;
	height: 25px;
}
.p_td{
	width: 100px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="xuqiumingxi.html";
   document.getElementById("fom").submit();
}
</SCRIPT>

<body>
<form name="fom" id="fom" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">      
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21">&nbsp;</td>
			  </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
         
              <tr>
                <TD height="40" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
					<tr>
                    	<td height="20" colspan="3" bgcolor="#EEEEEE"class="tablestyle_title">
							<div align="center" style="font-size:16px">设备展示详细</div>
						</td>
                    </tr>
                  <tr bgcolor="#FFFFFF" class="glory_detial">
				    <td width="150px" align="right">设备展示图片:</td>
                    <td><img class="control_glory_detial" src="../images/welcome.gif"></td>
                    <td class="p_td" ><input name="Submit2" type="button" class="p_button" value="更改图片"/></td>
                    </tr>
                	<tr bgcolor="#FFFFFF">
				    	<td align="right">设备展示简介:</td>
				    	<td>编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容编辑内容</td>
				    	<td><input name="Submit2" type="button" class="p_button" value="编辑内容"/></td>
                   </tr>
                	</table>
				</TD>
			
              </tr>
			  <tr>
			  	<TD><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">5</span> 条项目 | 共 <span class="right-text09">1</span> 页</td>
                <td width="49%" align="right">[<a href="#" class="right-font08">第一页</a> | <a href="#" class="right-font08">上一页</a> | <a href="#" class="right-font08">下一页</a> | <a href="#" class="right-font08">最后一页</a>] 跳转至</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table>
				</TD>
			  </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
