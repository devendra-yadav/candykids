<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="taglibs.jsp" %>
<html>
<head>
<link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Categories</title>
</head>
<body class="body-color">
	<%@ include file="header.jsp" %>
	<h2 align="center">All Categories</h2>
	<a href="${pageContext.request.contextPath}/category/form-add-category"><input type="button" value="Add New Category"></a>
	<div align="center">
		<c:if test="${result !=null}">
			<c:if test="${result['success'] !=null}">
				<div class="action-success">
					<i>${result['success']}</i>
				</div>
			</c:if>
			<c:if test="${result['failure'] !=null}">
				<div class="action-failure">
					<i>${result['failure']}</i>
				</div>
			</c:if>
		</c:if>
		<br>
	</div>
	<div align="center">
		<table class="beautiful">
			<tr>
				<th>Category Id</th>
				<th>Category Name</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${allCategories}" var="category">
				<tr>
					<td>${category.categoryId}</td>
					<td>${category.name}</td>
					<td>
						<a href="${pageContext.request.contextPath}/category/showEditForm?categoryId=${category.categoryId}" title="Edit Category"><input type="button" value="Edit"></a>
						<a href="${pageContext.request.contextPath}/category/deleteCategory?categoryId=${category.categoryId}" title="Delete Category" onclick="return confirm('Are you sure you want to delete -->${category.name}<-- category')"><input type="button" value="Delete"></a>
						<a href="#"><input type="button" value="View Items"></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>