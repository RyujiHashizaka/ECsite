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

	<title>ItemDetaConfirm画面</title>

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
			<p>ItemDetaConfirm</p>
		</div>
		<div>

			<s:if test="#session.message == 'update'">
				<h3>以下の内容に更新します。よろしければ更新ボタンを押してください。</h3>
			</s:if>

			<s:elseif test="#session.message == 'delete'">
				<h3>以下の商品を削除します。よろしければ削除ボタンを押してください。</h3>
			</s:elseif>

			<s:elseif test="#session.message == 'insert'">
				<h3>以下の内容で登録します。よろしければ登録ボタンを押してください。</h3>
			</s:elseif>

			<s:form action="ItemDetaCompleteAction">
				<table>
					<tr>
						<td>
							商品名:
						</td>
						<td>
							<s:property value="#session.selectItemName"/>
						</td>
					</tr>
					<tr>
						<td>
							価格:
						</td>
						<td>
							<s:property value="#session.selectItemPrice"/><span>円</span>
						</td>
					</tr>
					<tr>
						<td>
							在庫:
						</td>
						<td>
							<s:property value="#session.selectItemStock"/><span>個</span>
						</td>
					</tr>
					<tr>
						<td>
							商品説明:
						</td>
						<td>
							<s:property value="#session.selectItemText"/>
						</td>
					</tr>
				</table>
				<br>
				<table>
					<tr>
						<s:if test="#session.message == 'update'">
							<s:submit value="更新"/>
						</s:if>
						<s:if test="#session.message == 'delete'">
							<s:submit value="削除"/>
						</s:if>
						<s:if test="#session.message == 'insert'">
							<s:submit value="登録"/>
						</s:if>
					</tr>
				</table>
			</s:form>

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