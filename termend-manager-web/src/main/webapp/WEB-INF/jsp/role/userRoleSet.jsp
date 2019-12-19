<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户角色设置</title>
<link rel="stylesheet" type="text/css"
	href="ui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="ui/themes/icon.css">
<script type="text/javascript" src="ui/jquery.min.js"></script>
<script type="text/javascript" src="ui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="ui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src='ui/jquery.serializejson.min.js'></script>
<script type="text/javascript" src="js/userRoleSet.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript">
	//用于search.js自动补全
	var _url='user/searchUserName';
	var _value='user_name';
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'用户列表'"
		style="width: 600px;padding: 4px; background-color: #eee">
		<!--搜索区  -->
		<div data-options="region:'north',title:'查询'"
			style="padding: 4px; background-color: #eee; height: 40px">
			<form id="searchForm">
				<table cellpadding="5">
					<tr>
						<td>用户名：</td>
						<td><input name="user_name" class="easyui-combobox"
							id="inputtable" /></td>
						<td><a class="easyui-linkbutton"
							data-options="iconCls:'icon-search'" id="btnSearch">查询</a></td>
						<td><a class="easyui-linkbutton"
							data-options="iconCls:'icon-remove'" id="btnReset">重置</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="height: 4px;"></div>
		<table id="grid"></table>
	</div>
	<div data-options="region:'east',title:'角色列表',split:true"
		style="width: 500px;">
		<ul id="tree"></ul>
		<button id="btnSave">保存</button>
	</div>

</body>
</html>