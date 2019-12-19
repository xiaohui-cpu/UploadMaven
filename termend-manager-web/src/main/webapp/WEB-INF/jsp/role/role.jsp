<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>角色管理</title>
<link rel="stylesheet" type="text/css"
	href="ui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="ui/themes/icon.css">
<script type="text/javascript" src="ui/jquery.min.js"></script>
<script type="text/javascript" src="ui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="ui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src='ui/jquery.serializejson.min.js'></script>
<script type="text/javascript" src="js/crud.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript">
	//用于search.js自动补全
	var _url = 'role/searchRoleName';
	var _value = 'name';
	//用于crud.js的esayui初始参数
	var name = "role/role";
	var title = '角色管理';
	var idField = 'uuid';
	var columns = [ [ {
		field : 'name',
		title : '名称',
		width : 100
	} ] ];
</script>
</head>
<body class="easyui-layout">
	<!--搜索区  -->
	<div data-options="region:'north',title:'查询'"
		style="padding: 4px; background-color: #eee; height: 80px">
		<form id="searchForm">
			<table cellpadding="5">
				<tr>
					<td>角色名 ：</td>
					<td><input name="name" class="easyui-combobox" id="inputtable" /></td>
					<td><a class="easyui-linkbutton"
						data-options="iconCls:'icon-search'" id="btnSearch">查询</a></td>
					<td><a class="easyui-linkbutton"
						data-options="iconCls:'icon-remove'" id="btnReset">重置</a></td>
			</table>
		</form>
	</div>
	<!-- 数据表格区 -->
	<div data-options="region:'center',collapsible:true,split:true"
		style="width: 600px;">
		<table id="grid"></table>
	</div>
	<!-- 添加、修改 -->
	<div id="editDlg" class="easyui-window" data-options="closed:true">
		<form id="editForm">
			<input name="uuid" type="hidden">

			<table>
				<tr>
					<td>名称</td>
					<td><input name="name"></td>
				</tr>
			</table>
			<button id="btnSave" type="button">保存</button>
		</form>
	</div>
</body>
</html>
