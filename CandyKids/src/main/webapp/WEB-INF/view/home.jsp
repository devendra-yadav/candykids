<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="taglibs.jsp" %>
<html>
<head>
<link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candy Kids Home</title>
</head>
<body class="body-color">
	<%@ include file="header.jsp" %>
	<div align="center">
		<table>
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/category/form-add-category"><input type="button" class="button-link" value="Add Category"></a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/category/showAllCategories"><input type="button" class="button-link" value="Show Categories"></a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/items/form-add-item"><input type="button" class="button-link" value="Add New Item"></a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/items/showAllItems"><input type="button" class="button-link" value="Show All Items"></a>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/items/formShowItemsForGivenCategory"><input type="button" class="button-link" value="Show Items For Specific Category"></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>