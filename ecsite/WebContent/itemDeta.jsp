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

	<title>ItemDeta画面</title>

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
			<p>ItemDeta</p>
		</div>
		<div>
			<s:if test="message == 'update'">
				<h3>変更する項目に入力後、確認ボタンを押してください。</h3>
				<s:form action="ItemDetaConfirmAction">
					<table>
						<tr>
							<s:textfield name="itemName" label="商品名" value="%{#session.selectItemName}" required="required"/>
						</tr>
						<tr>
							<s:textfield name="itemPrice" label="価格" value="%{#session.selectItemPrice}" required="required"/>
						</tr>
						<tr>
							<s:textfield name="itemStock" label="在庫" value="%{#session.selectItemStock}" required="required"/>
						</tr>
						<tr>
							<s:textarea name="itemText" rows="8" cols="40" label="商品説明" value="%{#session.selectItemText}"/>
						</tr>
					</table>
					<br>
					<table>
						<tr>
							<td>
								<s:submit value="確認"/>
							</td>
						</tr>
					</table>
				</s:form>
			</s:if>

			<s:elseif test="message == 'insert'">
				<h3>追加する商品の情報を入力してください。</h3>
				<s:form action="ItemDetaConfirmAction">
					<table>
						<tr>
							<s:textfield name="itemName" label="商品名" placeholder="商品名を入力してください" required="required"/>
						</tr>
						<tr>
							<s:textfield name="itemPrice" label="価格" placeholder="価格を入力してください" required="required"/>
						</tr>
						<tr>
							<s:textfield name="itemStock" label="在庫" placeholder="数量を入力してください" required="required"/>
						</tr>
						<tr>
							<s:textarea name="itemText" rows="8" cols="40" label="商品説明" placeholder="説明文を入力してください"/>
						</tr>
					</table>
					<br>
					<table>
						<tr>
							<td>
								<s:submit value="確認"/>
							</td>
						</tr>
					</table>
				</s:form>
			</s:elseif>

			<div id="text-right">
				<p>商品一覧へ戻る場合は<a href='<s:url action="ItemListAction"/>'>こちら</a></p>
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