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
<title>CartList画面</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
<jsp:include page="header.jsp" />
	<div id="main">
		<div id="containar">
			<h3>〜　買い物かごの確認　〜</h3>
			<s:if test="cartListDTO == null">
				<h3>買い物かごは空っぽです</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>購入する方は、購入ボタンを押して進んでください</h3>
				<table>
					<tr>
						<th>商品名</th>
						<th>個数</th>
						<th>合計金額</th>
						<th>カートに入れた時間</th>

					</tr>
					<s:iterator value="cartListDTO">
						<tr>
							<td><s:property value="itemName"/></td>
							<td><s:property value="totalCount"/><span>個</span></td>
							<td><s:property value="totalPrice"/><span>円</span></td>
							<td><s:property value="insertDate"/></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="BillAction">
					<s:submit value="購入画面へ進む" method="execute" class="btn"/>
				</s:form>
				<s:form action="CartListDeleteCompleteAction">
					<s:submit value="カートを空にする" method="execute" class="btn btn2"/>
				</s:form>

			</s:elseif>
			<s:if test="message != null">
				<h3><s:property value="message"/></h3>
			</s:if>
			<div id="text-right">
				<p>画面へ戻る場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>