<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="taglibs.jsp" %>
<html>
<head>
<link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Category</title>
</head>
<body class="body-color">
	<%@ include file="header.jsp" %>
	<h2 align="center">Add New Category</h2>
	<a href="${pageContext.request.contextPath}/category/showAllCategories"><input type="button" class="link" value="Show All Categories"></a>
	<div align="center">
		<c:if test="${result != null}">
			<div>
				<c:if test="${result['success'] != null}">
					<div class="action-success">
						<i>${result['success']}</i>
					</div>
				</c:if>
				<c:if test="${result['failure'] != null}">
					<div class="action-failure">
						<i>${result['failure']}</i>
					</div>
				</c:if>
			</div>
			<br>
		</c:if>
		<form:form method="POST" action="${pageContext.request.contextPath}/category/addCategory" modelAttribute="category">
			<table>
				<tr>
					<td>Category Name</td>
					<td>
						<form:input path="name"/>
						<form:errors path="name" cssClass="error-invalid"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Add"/>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
	
</body>
</html>