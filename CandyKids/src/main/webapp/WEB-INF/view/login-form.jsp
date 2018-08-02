<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
<title>CandyKids Login form</title>
</head>
<body class="body-color">
	<center>
		<img src="${pageContext.request.contextPath}/resources/images/app/ck.jpg">
		<h2>Login Form</h2>
		
		<c:if test="${param.error !=null }">
			<div class="error-invalid">
				<i>Invalid username or password.</i>
			</div>
		</c:if>
		<c:if test="${param.logout !=null }">
			<div class="action-normal">
				<i>You have been logged out.</i>
			</div>
		</c:if>
		<br>
		<form:form method="POST"
			action="${pageContext.request.contextPath}/processLogin">
			
			<table>
				<tr>
					<td>User</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" class="submit" value="Login"></td>
				</tr>
			</table>
			
			
		</form:form>
	</center>
</body>
</html>