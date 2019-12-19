<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<title>灵犀外卖登录注册页面</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="content">
        <div class="form sign-in">
            <h2>灵犀外卖登录</h2>
            <label>
                <span>用户名</span>
                <input name="username" value="admin" type="username" />
            </label>
            <label>
                <span>密码</span>
                <input name="password" value="admin" type="password" />
            </label>
            <p class="forgot-pass"><a href="javascript:">忘记密码？</a></p>
            <button  id="login" type="button" class="submit">登 录</button>
            <!-- <button type="button" class="fb-btn">使用 <span>facebook</span> 帐号登录</button> -->
        </div>
        <div class="sub-cont">
            <div class="img">
                <div class="img__text m--up">
                    <h2>还未注册？</h2>
                    <p>立即注册，发现大量机会！</p>
                </div>
                <div class="img__text m--in">
                    <h2>已有帐号？</h2>
                    <p>有帐号就登录吧，好久不见了！</p>
                </div>
                <div class="img__btn">
                    <span class="m--up">注 册</span>
                    <span class="m--in">登 录</span>
                </div>
            </div>
            <div class="form sign-up">
                <h2>立即注册</h2>
                <label>
                    <span>用户名</span>
                    <input name="re_username" type="text" />
                </label>
                <label>
                    <span>密码</span>
                    <input name="re_password" type="password" />
                </label>
                <label>
                    <span>确认密码</span>
                    <input name="re_passwordNext" type="password" />
                </label>
                <button id="register" type="button" class="submit">注 册</button>
                <!-- <button type="button" class="fb-btn">使用 <span>facebook</span> 帐号注册</button> -->
            </div>
        </div>
    </div>
    <script src="js/script.js"></script>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
    
    	$("#login").click(function(){
    		
    		var username = $("[name=username]").val();
    		var password = $("[name=password]").val();

			if(username.trim() == "" || password.trim() == "") {
				alert("用户名或者密码不能为空!");
				return;
			}
			$.ajax({
				url: "/toLogin",
				data: {
					"usrName": username,
					"usrPassword": password
				},
				success: function(result) {
					if(result.status == 200) {
						window.location.href = "/toIndex"
					} else {
						alert(result.msg);
					}
				}
			});
			
    	});
    	
    	$("#register").click(function(){
    		var username = $("[name=username]").val();
    		var password = $("[name=password]").val();
    		var passwordNext = $("[name=re_passwordNext]").val();
    		
    		if(username==""||username==null){
    			alert("请输入用户名")
    			break;
    		}else if(password==""||password==null){
    			alert("请输入密码")
    			break;
    		}else if(passwordNext==""||passwordNext==null){
    			alert("请再次输入密码")
    			break;
    		}else if(password!=passwordNext){
    			alert("两次密码不一致")
    			break;
    		}else{
    			$.ajax({
    				url: "/toRegister",
    				data: {
    					"usrName": username,
    					"usrPassword": passwordNext
    				},
    				success: function(result) {
    					if(result.status == 200) {
    						alert("注册成功请登录")
    					} else {
    						alert(result.msg);
    					}
    				}
    			});
    		}
    	});
    </script>
    
</body>
</html>