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
input{
   cursor:pointer
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
  font-family:'微软雅黑',"yahei","Tahoma","Helvetica","arial","sans-serif";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {
  font-family:'微软雅黑',"yahei","Tahoma","Helvetica","arial","sans-serif";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {
  font-family:'微软雅黑',"yahei","Tahoma","Helvetica","arial","sans-serif";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family:'微软雅黑',"yahei","Tahoma","Helvetica","arial","sans-serif";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/xiangmu.js"></script>
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
   location.href="00knowledge.jsp";
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
</SCRIPT>

<body onload="on_load()">

<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="../images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td class="control_title">
            包装常识管理版面
          </td>
        </tr>
		 
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td>
           <form action="deletepackmulti.html" method="post" name="delform" target="mainFrame">
          <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20"><span class="newfont07">操作：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
                 <input name="delstr" type="hidden" id="hid"/>
                 <input name="Submit3" type="button" class="right-button08" value="删除选中信息" onclick="getselect()" />
                 <input name="Submit2" type="button" class="right-button08" value="添加信息" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td height="20" colspan="4" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> 查看上线包装常识</td>
                  </tr>
                  <tr>
                    <td width="4%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="30%" height="20" align="center" bgcolor="#EEEEEE">包装常识标题</td>
                    <td width="50%" align="center" bgcolor="#EEEEEE">包装常识内容</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                 
                  <c:forEach items="${list}" var="art">
                   <tr align="center">
                    <td bgcolor="#FFFFFF"><input type="checkbox" name="check" value="${art.id}"/></td>
                    <td height="20" bgcolor="#FFFFFF">${art.title}</td>
                    <td bgcolor="#FFFFFF" class="product_font1">${art.content}</td>
                    <td bgcolor="#FFFFFF"><a href="deletepack.html?art.id=${art.id}">删除</a>|<a href="getpackedit.html?art.id=${art.id}">编辑</a>|<a href="getpackdetail.html?art.id=${art.id}">详细</a></td>
                  </tr>
                  </c:forEach>
                </table></td>
              </tr>
            </table>
            </form>
            </td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%"><span class="right-text09"></span> 共${count}条记录 | 共${pageCount}页 <span class="right-text09"></span></td>
                <td width="49%" align="right">[<a href="getpacklist.html?currentPage=1" class="right-font08">第一页</a> |
                 <a href="getpacklist.html?currentPage=${currentPage-1}" class="right-font08">上一页</a> | 
                 <a href="getpacklist.html?currentPage=${currentPage+1}" class="right-font08">下一页</a> | 
                 <a href="getpacklist.html?currentPage=${pageCount}" class="right-font08">最后一页</a>] 跳转至</td>
                <td width="1%">
                 <form  method="post" action="getpacklist.html">
                   <table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="currentPage" type="text" class="right-textfield03" style="height:20px;width:20px;" /></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table>
                </form>
                </td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>


<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="file:///F|/ÏîÄ¿¹ÜÀíÏà¹Ø×ÊÁÏ/ÏîÄ¿¹ÜÀíÏµÍ³Ò³Ãæ/images/loadon.gif" />
</div>
<script type="text/javascript">
  function $(id){
	  return document.getElementById(id);
  }
  function getselect(){
	  var str="";
	  var select=document.getElementsByName("check");
	  for(var i=0;i<select.length;i++){
		  if(select[i].checked){
			  str+=select[i].value+",";
		  }
	  }
	  $("hid").value=str.substring(0,str.length-1);
	  delform.submit();
  }
</script>
</body>
</html>
