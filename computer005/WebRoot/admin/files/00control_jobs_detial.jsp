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
							<div align="center" style="font-size:16px">人才招聘详细</div>
						</td>
                    </tr>
                  <tr bgcolor="#FFFFFF" class="glory_detial">
				    <td width="150px" align="right">招聘单位:</td>
                    <td>${job.unit}</td>
                   
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
				    <td width="150px" align="right">工作地点:</td>
                    <td>${job.place}</td>
                    
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
				    <td width="150px" align="right">招聘人数:</td>
                    <td>${job.num}</td>
                   
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
				    <td width="150px" align="right">职位名称:</td>
                    <td>${job.job_name}</td>
                    
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
				    <td width="150px" align="right">职位类型:</td>
                    <td>${job.job_type}</td>
                    
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
				    <td width="150px" align="right">工作经验:</td>
                    <td>${job.experience}</td>
                    
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
            <td width="150px" align="right">学历要求:</td>
                    <td>${job.quality}</td>
                   
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
            <td width="150px" align="right">发布时间:</td>
                    <td>${job.post_time}</td>
                    
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
            <td width="150px" align="right">职位描述:</td>
                    <td>${job.description}</td>
                   
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
            <td width="150px" align="right">招聘要求:</td>
                    <td>${job.requirement}</td>
                    
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
            <td width="150px" align="right">联系人:</td>
                    <td>${job.contactor}</td>
                    
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
            <td width="150px" align="right">联系电话:</td>
                    <td>${job.phone}</td>
                   
                    </tr>
                    <tr bgcolor="#FFFFFF" class="glory_detial">
            <td width="150px" align="right">联系邮箱:</td>
                    <td>${job.email}</td>
                    
                    </tr>
                	</table>
				</TD>
			
              </tr>
			  <tr>
			  	<TD align="right">
			  	   <a href="modifyjob.html?job.id=${job.id}" style="font-size: 12px; color:blue;text-decoration: none;">编辑内容</a>
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
