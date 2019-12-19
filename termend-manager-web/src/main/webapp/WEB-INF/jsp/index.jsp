<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>灵犀外卖后台管理系统</title>
<%@include file="/WEB-INF/common.jsp"%>
<style type="text/css">
.content {
	padding: 10px 10px 10px 10px;
}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true"
		style="overflow: hidden; color: black; text-align: center; height: 60px; background: #D1EEEE; border-style: solid;">
		<h1>
			灵犀外卖后台管理系统<a href="/loginout" style="position: relative; left: 20%;">${username}退出</a>
		</h1>
	</div>
	<div data-options="region:'west',title:'菜单',split:true"
		style="width: 180px;">
		<ul id="menu" class="easyui-tree"
			style="margin-top: 10px; margin-left: 5px;">
			<!-- <li><span>商品管理</span>
				<ul>
					<li data-options="attributes:{'url':'/pages/disk-add'}">新增商品</li>
					<li data-options="attributes:{'url':'/pages/disk'}">所有商品</li>
				</ul></li>
			<li><span>菜单管理</span>
				<ul>
					<li data-options="attributes:{'url':'/pages/menu-category'}">菜单管理</li>
					<li data-options="attributes:{'url':'/pages/menu'}">菜单分类</li>
				</ul></li>
			<li><span>订单管理</span>
				<ul>
					<li data-options="attributes:{'url':'/pages/order'}">订单总览</li>
				</ul></li>
			<li><span>老板查账</span>
				<ul>
					<li data-options="attributes:{'url':'/pages/statistics'}">收入统计</li>
				</ul></li>
			<li><span>评价管理</span>
				<ul>
					<li data-options="attributes:{'url':'/pages/evaluate'}">评价总览</li>
				</ul></li>
			<li><span>系统管理</span>
				<ul>
					<li data-options="attributes:{'url':'/pages/shopinfo'}">店铺信息</li>
				</ul></li> -->
				
		</ul>
	</div>
	<div data-options="region:'center',title:''">
		<div id="tabs" class="easyui-tabs">
			<div title="首页" style="padding: 20px;">
				<!-- dog显示div -->
				<div id="world"></div>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/js/plugin-dog/js/three.min.js"></script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/js/plugin-dog/js/OrbitControls.js"></script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/js/plugin-dog/js/index.js"></script>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	function splitLast(lists) {
		// 保存拼接后的字符串 
		var str = "";
		/* 保存父元素，用于判断 */
		var parentStr ="";
		var jsonLength=0;
		for (var i in lists) {
            jsonLength++;
        }
		for(var i in lists){
			
			if(lists[i].rightType=="Folder"){
				if(parentStr==""||parentStr==null){
					/*如果是第一个父节点 */
					parentStr = lists[i].rightCode;
					str= str + "<li><span>"+lists[i].rightText+"</span><ul>";
				}else{
					str= str + "</ul></li>";
					/*如果不是第一个父节点 */
					parentStr = lists[i].rightCode;
					str= str + "<li><span>"+lists[i].rightText+"</span><ul>";
				}
			}else if(lists[i].rightType=="Document"){
				// 如果是子节点 
				str= str + "<li data-options=\"attributes:{\'url\':\'"+lists[i].rightUrl+"\'}\">"+lists[i].rightText+"</li>";
				if(i==jsonLength-1){
					// 如果是最后一个子节点 
					str= str + "</ul></li>";
				}
			}
		}
		return str;
	}
		$(function() {	
			var lists=  <%=session.getAttribute("lists")%>; 
			var str = splitLast(lists);
			$("#menu").append(str);
			
			$('#menu').tree({
				onClick : function(node) {
					if ($('#menu').tree("isLeaf", node.target)) {
						var tabs = $("#tabs");
						var tab = tabs.tabs("getTab", node.text);
						if (tab) {
							tabs.tabs("select", node.text);
						} else {
							tabs.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
		});
	</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>	
</body>
</html>