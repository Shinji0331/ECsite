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
<title>ItemDetail画面</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<script type="text/javascript">
function view() {
	alert('カートに商品を入れました！', '決済は上のカートボタンからお願いします', 'success');
}
</script>
</head>
<body>
<jsp:include page="header.jsp" />
	<div id="main">
		<div id="containar">
			<h3>〜　商品詳細　〜</h3>
				<s:iterator value="#session.itemDetailDTO">
				<div class="item-image-box-400">
					<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'>
				</div>
				<div class="item-detail">
					<table>
						<tr>
							<td width="150">商品名</td>
							<td width="30">：</td>
							<td><s:property value="itemName"/></td>
						</tr>
						<tr>
							<td>商品名(ひらがな)</td>
							<td>：</td>
							<td><s:property value="itemNameKana"/></td>
						</tr>
						<tr>
							<td>商品説明</td>
							<td>：</td>
							<td><s:property value="itemDescription"/></td>
						</tr>
						<tr>
							<td>販売会社</td>
							<td>：</td>
							<td><s:property value="releaseCompany"/></td>
						</tr>
						<tr>
							<td>販売開始日</td>
							<td>：</td>
							<td><s:property value="releaseDate"/></td>
						</tr>
					</table><br/>
					<div class="item-detail-price detail">
						<strong><i class="fas fa-yen-sign"></i><s:property value="itemPrice"/>円</strong><span>(税込)</span>
					</div>
					<s:form action="CartAction">
					<div class="item-detail-count detail">
						<span>個数：</span>
						<select name="count">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select><br/>
					</div>
					<input type="hidden" name="itemId" value="<s:property value="itemId"/>"/>
					<input type="hidden" name="itemName" value="<s:property value="itemName"/>"/>
					<input type="hidden" name="itemPrice" value="<s:property value="itemPrice"/>"/>
					<input type="submit" value="&#xf218;  カートへ入れる" class="fas detailbtn" onclick="view()">
					</s:form>
				</div>
				</s:iterator>
			<div id="text-right">
				<p>画面へ戻る場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>