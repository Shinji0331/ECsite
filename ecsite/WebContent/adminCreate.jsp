<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>AdminCreate画面</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div id="main">
		<div id="header">
			<div class="title"><h1>ENJOY! SHOPPING!!</h1></div>
		</div>
		<div id="containar">
			<h3>登録する管理者情報を入力してください</h3>
			<s:if test="errorMessage!=''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<table>
				<s:form action="AdminCreateConfirmAction">
					<tr>
						<td>
							<label>名前：</label>
						</td>
						<td>
							<input type="text" name="createAdminId"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>パスワード：</label>
						</td>
						<td>
							<input type="text" name="createAdminPass"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>ユーザー：</label>
						</td>
						<td>
							<input type="text" name="createAdminName"/>
						</td>
					</tr>
					<s:submit value="上記の管理者を登録" class="btn"/>
				</s:form>
			</table>

		</div>
		<div>
			<s:form action="AdminHomeAction">
				<s:submit value="管理画面に戻る"/>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<p>copyright &copy; 2018 Shinji Kobayashi All rights reserved.</p>
	</div>
</body>
</html>