<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="taglibs.jsp" %>
<html>
<head>
<link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="body-color">
	<%@ include file="header.jsp" %>
	<h2 align="center">Choose Category</h2>
	
	<div align="left">
		<a href="${pageContext.request.contextPath}/items/showAllItems"><input type="button" class="link" value="Show All Items"></a>
	</div>
	
	<div align="center">
		<c:if test="${allCategories!=null}">
			<form:form method="GET" action="${pageContext.request.contextPath}/items/showItemsForGivenCategory">
				<select name="category">
					<c:forEach items="${allCategories}" var="tempCategory">
						<c:if test="${(chosenCategory!=null) && (chosenCategory==tempCategory.name)}">
							<option value="${tempCategory.name}" selected="selected">${tempCategory.name}</option>
						</c:if>
						<c:if test="${chosenCategory!=tempCategory.name}">
							<option value="${tempCategory.name}">${tempCategory.name}</option>
						</c:if>
					</c:forEach>
				</select>
				<input type="submit" value="Show Items">
			</form:form>
		</c:if>
		<c:if test="${allCategories==null}">
			<h3>There are no categories</h3>
		</c:if>
		<br>
	</div>
	
	<div align="center">
		<c:if test="${allItems!=null}">
			<table class="beautiful">
			<tr>
				<th>ItemId</th>
				<th>Title</th>
				<th>Description</th>
				<th>Cost Price</th>
				<th>Selling Price</th>
				<th>Category</th>
				<th>Image</th>
				<th>Supplier</th>
				<th>Entry Date</th>
				<th>Comments</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${allItems}" var="item">
				<tr>
					<td>${item.itemId}</td>
					<td width="15%">${item.title}</td>
					<td width="20%">${item.description}</td>
					<td>${item.costPrice}</td>
					<td>${item.sellingPrice}</td>
					<td>${item.category.name}</td>
					<td>
						<a href="${item.imagePath}" target="_blank"><img src="${item.imagePath}" height="100" width="100"></a>
					</td>
					<td width="10%">${item.supplier}</td>
					<td>${item.entryDate}</td>
					<td width="10%">${item.comments}</td>
					<td>
						<a href="${pageContext.request.contextPath}/items/formEditItem?itemId=${item.itemId}"><input type="button" class="link" value="Edit"></a>
						<a href="${pageContext.request.contextPath}/items/deleteItem?itemId=${item.itemId}" title="Delete Item" onclick="return confirm('Are you sure you want to delete item with item id -->${item.itemId}<--')"><input type="button" class="link" value="Delete"></a>
					</td>
				</tr>
			</c:forEach>
			
			</table>
		</c:if>
		<c:if test="${chosenCategory!=null}">
			<c:if test="${allItems==null}">
				<h4>There are no items in '${chosenCategory}' category</h4>
			</c:if>
		</c:if>
		
	</div>
</body>
</html>