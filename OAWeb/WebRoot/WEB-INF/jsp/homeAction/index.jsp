<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Itcast OA</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>	
	<script type="text/javascript" src="${ctx}/script/jquery_treeview/jquery.cookie.js"></script>
</head>

	<frameset rows="100,*,25" framespacing=0 border=0 frameborder="0">
		<frame noresize name="TopMenu" scrolling="no" src="${ctx}/home_top.htm">
		<frameset cols="180,*" id="resize">
			<frame noresize name="menu" scrolling="yes" src="${ctx}/home_left.htm">
			<frame noresize name="right" scrolling="yes" src="${ctx}/home_right.htm">
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="${ctx}/home_bottom.htm">
	</frameset>

	<noframes><body>
</body>
</noframes></html>



