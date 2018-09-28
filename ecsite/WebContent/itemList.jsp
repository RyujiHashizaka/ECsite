<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<meta http-equiv="Content-Script-Type" content="text/javascript">
	<meta http-equiv="imagetoolbar" content="no">
	<meta name="description" content="">
	<meta name="keywords" content="">

	<title>ItemList画面</title>

	<style type="text/css">
		/* ========TAG LAYOUT======== */
		body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana,Helvetica,sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
		}

		table{
			text-align:center;
			margin:0 auto;
		}

		/* ========ID LAYOUT======== */
		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
		}

		#header{
			width:100%;
			height:80px;
			background-color:black;
		}

		#main{
			width:100%;
			height:500px;
			text-align:center;
		}

		#footer{
			width:100%;
			height:80px;
			background-color:black;
			clear:both;
		}

		#text-right{
			display:inline-block;
			text-align:right;
		}

	</style>

</head>

<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>ItemList</p>
		</div>
		<div>
			<s:if test="itemList == null">
				<h3>登録済商品はありません。</h3>
			</s:if>
			<s:elseif test="itemList != null">
				<h3>登録済商品は以下になります。</h3>
				<table border="1">
					<tr>
						<th>コード</th>
						<th>品名</th>
						<th>価格</th>
						<th>在庫</th>
						<th>登録日</th>
						<th></th>
					</tr>
					<s:iterator value="itemList">
						<tr>
							<td><s:property value="id"/></td>
							<td><s:property value="item_name"/></td>
							<td><s:property value="item_price"/><span>円</span></td>
							<td><s:property value="item_stock"/><span>個</span></td>
							<td><s:property value="insert_date"/></td>
							<td>
								<s:form action="ItemDetaAction">
									<input type="hidden" name="itemDetaFlg" value="update">
									<input type="hidden" name="itemDetaId" value='<s:property value="id"/>'>
									<s:submit value="編集"/>
								</s:form>
								<s:form action="ItemDetaAction">
									<input type="hidden" name="itemDetaFlg" value="delete">
									<input type="hidden" name="itemDetaId" value='<s:property value="id"/>'>
									<s:submit value="削除"/>
								</s:form>
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:elseif>

			<s:form action="ItemDetaAction">
				<input type="hidden" name="itemDetaFlg" value="insert">
				<s:submit value="商品追加"/>
			</s:form>

			<div id="text-right">
				<p>管理画面TOPへ戻る場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>

</html>