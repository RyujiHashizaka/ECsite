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

	<title>UserDeta画面</title>

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
			<p>UserDeta</p>
		</div>
		<div>
			<s:if test="message == 'update'">
				<h3>変更する項目に入力後、確認ボタンを押してください。</h3>
				<s:form action="UserDetaConfirmAction">
					<table>
						<tr>
							<s:textfield name="userLoginId" label="ログインID" value="%{#session.selectUserLoginId}" required="required"/>
						</tr>
						<tr>
							<s:textfield name="userLoginPass" label="ログインPASS" value="%{#session.selectUserLoginPass}" required="required"/>
						</tr>
						<tr>
							<s:textfield name="userName" label="ユーザー名" value="%{#session.selectUserName}" required="required"/>
						</tr>
						<tr>
							<s:textfield name="userAddress" label="住所" value="%{#session.selectUserAddress}" required="required"/>
						</tr>
						<tr>
							<s:select name="userTitle" label="ユーザー権限" list="#{'1':'admin','2':'user'}" value="#session.userTitleValue"/>
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
				<h3>追加するユーザーの情報を入力してください。</h3>
				<s:form action="UserDetaConfirmAction">
					<table>
						<tr>
							<s:textfield name="userLoginId" label="ログインID" placeholder="ログインIDを入力してください" required="required"/>
						</tr>
						<tr>
							<s:textfield name="userLoginPass" label="ログインPASS" placeholder="ログインPASSを入力してください" required="required"/>
						</tr>
						<tr>
							<s:textfield name="userName" label="ユーザー名" placeholder="ユーザー名を入力してください" required="required"/>
						</tr>
						<tr>
							<s:textfield name="userAddress" label="住所" placeholder="住所を入力してください" required="required"/>
						</tr>
						<tr>
							<s:select name="userTitle" label="ユーザー権限" list="#{'':'選択してください','1':'admin','2':'user'}" value="0" required="required"/>
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
				<p>ユーザー一覧へ戻る場合は<a href='<s:url action="UserListAction"/>'>こちら</a></p>
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