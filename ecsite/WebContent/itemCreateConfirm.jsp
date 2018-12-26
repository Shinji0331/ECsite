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
<title>ItemCreateConfirm画面</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div id="main">
		<div id="header">
			<div class="title"><h1>ENJOY! SHOPPING!!</h1></div>
		</div>
		<div id="containar">
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="ItemCreateCompleteAction">
					<tr>
						<td>
							<label>商品名：</label>
						</td>
						<td>
							<s:property value="createItemName"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>商品価格：</label>
						</td>
						<td>
							<s:property value="createItemPrice"/>
						</td>
					</tr>
					<tr>
						<td>
							<label>商品在庫数：</label>
						</td>
						<td>
							<s:property value="createItemStock"/>
						</td>
					</tr>
					<s:submit value="登録" class="btn"/>
				</s:form>
			</table>
			<div>
				<span>入力画面に戻る場合は</span>
				<a href='<s:url action="ItemCreateAction"/>'>こちら</a>
			</div>
		</div>
	</div>
	<div id="footer">
		<p>copyright &copy; 2018 Shinji Kobayashi All rights reserved.</p>
	</div>
</body>
</html>