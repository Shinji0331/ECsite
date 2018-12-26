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
<title>BuyItem画面</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<script>
function clickEvent(){
	alert('買い物カゴに商品を入れました。');
}
</script>
</head>
<body>
<jsp:include page="header.jsp" />
	<div id="main">
		<div id="containar">
			<h3>商品一覧</h3>
			<div id="item-list">
			<s:iterator value="#session.nowPageIteminfo">
				<div class="item-list-box">
					<ul>
						<li>
							<a href='<s:url action="ItemDetailAction">
							<s:param name="itemId" value="itemId"/>
							</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box-200"/></a><br>
							<s:property value="itemName"/><br>
							<s:property value="itemPrice"/>円<br>
							<s:form action="CartAction">
								<span>個数：</span>
								<select name="count">
										<option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
								</select><br/>
								<input type="hidden" name="itemId" value="<s:property value="itemId"/>"/>
								<input type="hidden" name="itemName" value="<s:property value="itemName"/>"/>
								<input type="hidden" name="itemPrice" value="<s:property value="itemPrice"/>"/>
								<input type="submit" value="&#xf218;  カートへ入れる" class="fas btn cartbtn" onclick="clickEvent()">
							</s:form>
  						</li>
					</ul>
				</div>
			</s:iterator>
			</div>
			<div class="pager">
				<s:iterator begin="1" end="#session.totalPageSize" status="No">
				<s:if test="#session.nowPageNo == #No.count">
					<s:property value="%{#No.count}"/>
				</s:if>
				<s:else>
				<a href="<s:url action='HomeAction'><s:param name='pageNo' value='%{#No.count}'/></s:url>"><s:property value="%{#No.count}"/></a>
				</s:else>
				</s:iterator>
			</div>
			<div>
				<p>前ページに戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
			</div>

		</div>
	</div>
<jsp:include page="footer.jsp" />
</body>
</html>