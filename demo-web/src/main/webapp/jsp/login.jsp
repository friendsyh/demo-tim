<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<title>登录页面</title>
		<script language="javascript">
		   function reloadcode(){
		   var verify=document.getElementById('code');
		   verify.setAttribute('src','makeCertPic.jsp?it='+Math.random());
		}
		</script>
	</head>
	<body>
		<form action="/login" method="post">
			<table align="center" border="0">
				<tr align="center">
					<td>
						系统登录
					</td>
				</tr>
				<tr>
					<td>
						用户名：
						<input type="text" name="username" />
					</td>
				</tr>
				<tr>
					<td>
						密&nbsp;&nbsp;码：
						<input type="password" name="password" />
					</td>
				</tr>
				<tr>
					<td>
						验证码：
						<input type="text" name="certCode" />
						<img src="makeCertPic.jsp" id="code" onclick="reloadcode()"
                             style="cursor: pointer;" alt="看不清楚,换一张">
					</td>
				</tr>
				<tr align="left">
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="确定" />
					</td>
				</tr>
			</table>
		</form>
				<%= pageContext.getRequest()%>
	</body>
</html>
