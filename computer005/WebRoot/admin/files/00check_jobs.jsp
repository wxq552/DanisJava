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
    document.getElementById("fom").action="xiangmu.htm";
   document.getElementById("fom").submit();
}

</SCRIPT>

<body>
<form name="fom" id="fom" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="../images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
        <td class="control_title">
            产品管理版面
          </td>
			<!-- <td width="21"><img src="../images/ico07.gif" width="20" height="18" /></td>
			<td width="550">²é¿´ÄÚÈÝ£º °´ÏîÄ¿Ãû³Æ£º
              <input type="text" name="textfield2" />
              <input name="Submit" type="button" class="right-button02" value="²é Ñ¯" /></td>
			 <td width="132" align="left"><a href="#" onclick="sousuo()">
			   <input name="Submit" type="button" class="right-button07" value="¸ß¼¶ËÑË÷" /></a></td>	 -->
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20"><span class="newfont07">操作：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
	              <input name="Submit" type="button" class="right-button08" value="删除选中信息" />
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="13" align="center" bgcolor="#EEEEEE"class="tablestyle_title">人才招聘信息</td>
                    </tr>
                  <tr>
				    <td width="4%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="13%" height="20" align="center" bgcolor="#EEEEEE">ÏîÄ¿Ãû³Æ</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">µ¥Î»</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">ÏîÄ¿×Ü½ð¶î</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">ÏîÄ¿¸ºÔðÈË</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">ÏîÄ¿¿ª·¢ÈËÊý</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">³É±¾×ÜÖ§³ö</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">¿ªÊ¼Ê±¼ä</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">¼Æ»®Íê³ÉÊ±¼ä</td>
					<td width="7%" align="center" bgcolor="#EEEEEE">Êµ¼ÊÍê³ÉÊ±¼ä</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">ÈÎÎñÓÅÏÈ¼¶</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">Íê³É×´Ì¬</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">²Ù×÷</td>
                  </tr>
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td height="20" bgcolor="#FFFFFF">Á÷¶¯ÈË¿ÚÏîÄ¿</td>
                    <td bgcolor="#FFFFFF">µçÐÅ</td>
                    <td bgcolor="#FFFFFF">500Íò</td>
                    <td bgcolor="#FFFFFF">ÕÅÈý</td>
                    <td bgcolor="#FFFFFF">5</td>
                    <td bgcolor="#FFFFFF">300Íò</td>
                    <td bgcolor="#FFFFFF">2007-11-11</td>
                    <td bgcolor="#FFFFFF">2008-1-1</td>
                    <td bgcolor="#FFFFFF">2007-12-12</td>
                    <td bgcolor="#FFFFFF">¼±</td>
                    <td bgcolor="#FFFFFF">ÒÑ¾­Íê³É</td>
                    <td bgcolor="#FFFFFF"><a href="xiangmu.htm">±à¼­</a></td>
                  </tr>
                  <tr>
				   <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td height="20" bgcolor="#FFFFFF">gezhaofeng</td>
                    <td bgcolor="#FFFFFF">µçÐÅ</td>
                    <td bgcolor="#FFFFFF">500Íò</td>
                    <td bgcolor="#FFFFFF">ÕÅÈý</td>
                    <td bgcolor="#FFFFFF">5</td>
                    <td bgcolor="#FFFFFF">300Íò</td>
                    <td bgcolor="#FFFFFF">2007-11-11</td>
                    <td bgcolor="#FFFFFF">2008-1-1</td>
                    <td bgcolor="#FFFFFF">2007-12-12</td>
                    <td bgcolor="#FFFFFF">¼±</td>
                    <td bgcolor="#FFFFFF">ÒÑ¾­Íê³É</td>
                    <td bgcolor="#FFFFFF"><a href="xiangmu.htm">±à¼­</a></td>
                  </tr>
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td bgcolor="#FFFFFF">gezhaofeng</td>
                    <td bgcolor="#FFFFFF">µçÐÅ</td>
                    <td bgcolor="#FFFFFF">500Íò</td>
                    <td bgcolor="#FFFFFF">ÕÅÈý</td>
                    <td bgcolor="#FFFFFF">5</td>
                    <td bgcolor="#FFFFFF">300Íò</td>
                    <td bgcolor="#FFFFFF">2007-11-11</td>
                    <td bgcolor="#FFFFFF">2008-1-1</td>
                    <td bgcolor="#FFFFFF">2007-12-12</td>
                    <td bgcolor="#FFFFFF">¼±</td>
                    <td bgcolor="#FFFFFF">ÒÑ¾­Íê³É</td>
                    <td bgcolor="#FFFFFF"><a href="xiangmu.htm">±à¼­</a></td>
                  </tr>
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td bgcolor="#FFFFFF">gezhaofeng</td>
                    <td bgcolor="#FFFFFF">µçÐÅ</td>
                    <td bgcolor="#FFFFFF">500Íò</td>
                    <td bgcolor="#FFFFFF">ÕÅÈý</td>
                    <td bgcolor="#FFFFFF">5</td>
                    <td bgcolor="#FFFFFF">300Íò</td>
                    <td bgcolor="#FFFFFF">2007-11-11</td>
                    <td bgcolor="#FFFFFF">2008-1-1</td>
                    <td bgcolor="#FFFFFF">2007-12-12</td>
                    <td bgcolor="#FFFFFF">¼±</td>
                    <td bgcolor="#FFFFFF">ÒÑ¾­Íê³É</td>
                    <td bgcolor="#FFFFFF"><a href="xiangmu.htm">±à¼­</a></td>
                  </tr>
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td bgcolor="#FFFFFF">gezhaofeng</td>
                    <td bgcolor="#FFFFFF">µçÐÅ</td>
                    <td bgcolor="#FFFFFF">500Íò</td>
                    <td bgcolor="#FFFFFF">ÕÅÈý</td>
                    <td bgcolor="#FFFFFF">5</td>
                    <td bgcolor="#FFFFFF">300Íò</td>
                    <td bgcolor="#FFFFFF">2007-11-11</td>
                    <td bgcolor="#FFFFFF">2008-1-1</td>
                    <td bgcolor="#FFFFFF">2007-12-12</td>
                    <td bgcolor="#FFFFFF">¼±</td>
                    <td bgcolor="#FFFFFF">ÒÑ¾­Íê³É</td>
                    <td bgcolor="#FFFFFF"><a href="xiangmu.htm">±à¼­</a></td>
                  </tr>
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td bgcolor="#FFFFFF">gezhaofeng</td>
                    <td bgcolor="#FFFFFF">µçÐÅ</td>
                    <td bgcolor="#FFFFFF">500Íò</td>
                    <td bgcolor="#FFFFFF">ÕÅÈý</td>
                    <td bgcolor="#FFFFFF">5</td>
                    <td bgcolor="#FFFFFF">300Íò</td>
                    <td bgcolor="#FFFFFF">2007-11-11</td>
                    <td bgcolor="#FFFFFF">2008-1-1</td>
                    <td bgcolor="#FFFFFF">2007-12-12</td>
                    <td bgcolor="#FFFFFF">¼±</td>
                    <td bgcolor="#FFFFFF">ÒÑ¾­Íê³É</td>
                    <td bgcolor="#FFFFFF"><a href="xiangmu.htm">±à¼­</a></td>
                  </tr>
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td bgcolor="#FFFFFF">gezhaofeng</td>
                    <td bgcolor="#FFFFFF">µçÐÅ</td>
                    <td bgcolor="#FFFFFF">500Íò</td>
                    <td bgcolor="#FFFFFF">ÕÅÈý</td>
                    <td bgcolor="#FFFFFF">5</td>
                    <td bgcolor="#FFFFFF">300Íò</td>
                    <td bgcolor="#FFFFFF">2007-11-11</td>
                    <td bgcolor="#FFFFFF">2008-1-1</td>
                    <td bgcolor="#FFFFFF">2007-12-12</td>
                    <td bgcolor="#FFFFFF">¼±</td>
                    <td bgcolor="#FFFFFF">ÒÑ¾­Íê³É</td>
                    <td bgcolor="#FFFFFF"><a href="xiangmu.htm">±à¼­</a></td>
                  </tr>
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td bgcolor="#FFFFFF">gezhaofeng</td>
                    <td bgcolor="#FFFFFF">µçÐÅ</td>
                    <td bgcolor="#FFFFFF">500Íò</td>
                    <td bgcolor="#FFFFFF">ÕÅÈý</td>
                    <td bgcolor="#FFFFFF">5</td>
                    <td bgcolor="#FFFFFF">300Íò</td>
                    <td bgcolor="#FFFFFF">2007-11-11</td>
                    <td bgcolor="#FFFFFF">2008-1-1</td>
                    <td bgcolor="#FFFFFF">2007-12-12</td>
                    <td bgcolor="#FFFFFF">¼±</td>
                    <td bgcolor="#FFFFFF">ÒÑ¾­Íê³É</td>
                    <td bgcolor="#FFFFFF"><a href="xiangmu.htm">±à¼­</a></td>
                  </tr>
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td bgcolor="#FFFFFF">gezhaofeng</td>
                    <td bgcolor="#FFFFFF">µçÐÅ</td>
                    <td bgcolor="#FFFFFF">500Íò</td>
                    <td bgcolor="#FFFFFF">ÕÅÈý</td>
                    <td bgcolor="#FFFFFF">5</td>
                    <td bgcolor="#FFFFFF">300Íò</td>
                    <td bgcolor="#FFFFFF">2007-11-11</td>
                    <td bgcolor="#FFFFFF">2008-1-1</td>
                    <td bgcolor="#FFFFFF">2007-12-12</td>
                    <td bgcolor="#FFFFFF">¼±</td>
                    <td bgcolor="#FFFFFF">ÒÑ¾­Íê³É</td>
                    <td bgcolor="#FFFFFF"><a href="xiangmu.htm">±à¼­</a></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33">
		  <table width="100%" border="0" align="center" cellpadding="0" 
		  		cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">
					共<span class="right-text09">5</span>条记录|
				 共<span class="right-text09">1</span>页		
				</td>
                <td width="49%" align="right">
					[<a href="#" class="right-font08">第一页</a>|
					<a href="#" class="right-font08">上一页</a>| 
					<a href="#" class="right-font08">下一页</a>|
					<a href="#" class="right-font08">最后一页</a>]跳转至
				</td>
                <td width="1%">
					<table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%">
					  	<input name="textfield3" type="text" class="right-textfield03" size="1" />
					  </td>
                      <td width="87%">
					  	<input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table>
				</td>
              </tr>
          </table>
		 </td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
