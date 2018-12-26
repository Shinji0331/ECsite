<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ヘッダー</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<script>
function goCartListAction(){
	document.getElementById("form").action="CartListAction";
}
function goMyPageAction(){
	document.getElementById("form").action="MyPageAction";
}
function goAdminAction(){
	document.getElementById("form").action="AdminAction";
}
function goLogoutAction(){
	document.getElementById("form").action="LogoutAction";
}
function goLoginAction(){
	document.getElementById("form").action="LoginAction";
}
</script>
</head>
<body>
	<div id="header">
		<div class="title">ENJOY! SHOPPING!!</div>
		<s:form id="form" name="form">
			<div>
				<button class="basket-btn fas" onclick="goCartListAction()">&#xf218; カート</button>
			</div>
			<s:if test="#session.login_user_id != null">
			<div>
				<button class="btn2" onclick="goMyPageAction()">マイページ</button>
			</div>
			</s:if>
			<s:if test="#session.adminId != null">
			<div>
				<button class="btn2" onclick="goAdminAction()">管理者ページへ</button>
			</div>
			</s:if>
			<s:if test="#session.login_user_id != null">
			<div>
				<button class="btn2" onclick="goLogoutAction()">ログアウト</button>
			</div>
			</s:if>
			<s:if test='!(#session.containsKey("login_user_id"))'>
			<div>
				<button class="btn2" onclick="goLoginAction()">ログイン</button>
			</div>
			</s:if>
		</s:form>


	</div>
</body>
</html>