<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>员工管理</title>
<link rel="stylesheet" type="text/css"
	href="ui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="ui/themes/icon.css">
<script type="text/javascript" src="ui/jquery.min.js"></script>
<script type="text/javascript" src="ui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="ui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="ui/jquery.serializejson.min.js"></script>
<script type="text/javascript" src="ui/date.js"></script>
<script type="text/javascript" src="js/crud.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/download.js"></script>
<script type="text/javascript">
	//用于search.js自动补全
	var _url = 'user/searchUserName';
	var _value = 'user_name';
	//用于crud.js的esayui初始参数
	var name = "user/user";
	var title = '用户管理';
	var idField = 'user_id';
	var height = 300;
	var width = 300;
	var columns = [ [ {
		field : 'user_code',
		title : '账号',
		width : 100
	}, {
		field : 'user_pwd',
		title : '密码',
		width : 100,
		formatter : function(value) {
			return "*********";
		}
	}, {
		field : 'user_name',
		title : '真实姓名',
		width : 100
	}, {
		field : 'user_birthday',
		title : '出生日期',
		width : 100,
		formatter : function(value) {
			return new Date(value).Format("yyyy-MM-dd");
		}
	}, ] ];
</script>
</head>
<body class="easyui-layout">
	<!--搜索区  -->
	<div data-options="region:'north',title:'查询'"
		style="padding: 4px; background-color: #eee; height: 80px">
		<form id="searchForm">
			<table cellpadding="5">
				<tr>
					<td>真实姓名 ：</td>
					<td><input name="user_name" class="easyui-combobox"
						id="inputtable" /></td>
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
			<input name="user_id" type="hidden">
			<table>
				<tr>
					<td>账号</td>
					<td><input name="usrName" class="easyui-validatebox"
						data-options="
					required:true,missingMessage:'账号不能为空!'
					">
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="usrPassword"></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td><input name="user_name"></td>
				</tr>
				<tr>
					<td>出生日期</td>
					<td><input name="user_birthday" class="easyui-datebox"
						editable="false"></td>
				</tr>
			</table>
			<button id="btnSave" type="button">保存</button>
		</form>
	</div>
	<!-- 导入窗口 -->
	<div id="importDlg" style="padding: 2px;">
		<form id="importForm" enctype="multipart/form-data">
			导入文件:<input type="file" name="file">
		</form>
	</div>
</body>
</html>
