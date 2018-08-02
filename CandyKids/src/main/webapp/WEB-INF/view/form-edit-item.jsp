<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="taglibs.jsp" %>
<html>
<head>
<link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Item</title>
<script type="text/javascript">
	function showImage(elementId) {
		
		//Delete image if already there.
		var existingImageElement=document.getElementById("tempImage");
		
		if(existingImageElement != null){
			existingImageElement.remove();
		}
		
		//Create new image element.
		var imageElement=document.createElement("img");
		var imageUrl=document.getElementById(elementId).value.trim();
		
		//Add image element only if image url length > 0
		if(imageUrl.length > 0){
			imageElement.setAttribute("src",imageUrl);
			imageElement.setAttribute("width","250");
			imageElement.setAttribute("height","250");
			imageElement.setAttribute("id","tempImage");
			document.getElementById("imageplaceholder").appendChild(imageElement);
		}
		
	}
	
	
	function enableField(enableId,disableId){
		//alert(document.getElementById(enableId));
		//alert(document.getElementById(disableId));
		document.getElementById(enableId).disabled=false;
		document.getElementById(disableId).disabled=true;
		//alert("DONE");
	}
	
	function checkFormData(){
		var costPrice=document.getElementById("costPrice").value;
		var sellingPrice=document.getElementById("sellingPrice").value;
		var category=document.getElementById("category").value;
		
		var alertMessage="";
		if(isNaN(costPrice)){
			alertMessage=alertMessage+"Cost Price '"+costPrice+"' should be a number.\n";
		}
		
		if(isNaN(sellingPrice)){
			alertMessage=alertMessage+"Selling Price '"+sellingPrice+"' should be a number.\n";
		}
		
		if(category=="-"){
			alertMessage=alertMessage+"Please select a category for this item.\n";
		}
		
		if(alertMessage==""){
			return true;
		}else{
			alert(alertMessage);
			return false;
		}
	}
</script>
</head>
<body class="body-color">
	<%@ include file="header.jsp" %>
	<div align="center">
		<h2>Update Item</h2>
		<div align="left">
			<a href="${pageContext.request.contextPath}/items/showAllItems"><input type="button" class="button-link" value="Back to all items"></a>
		</div>
		
		<div>
			<c:if test="${result!=null}">
				<c:if test="${result['success']!=null}">
					<div class="action-success">
						<i>${result['success']}</i>
					</div>
				</c:if>
				<c:if test="${result['failure']!=null}">
					<div class="action-failure">
						<i>${result['failure']}</i>
					</div>
				</c:if>
			</c:if>
			<br>
		</div>
		
		<form:form method="POST" action="${pageContext.request.contextPath}/items/editItem" modelAttribute="item" enctype="multipart/form-data">
			<table>
				<tr>
					<td>Item ID</td>
					<td>${item.itemId}</td>
				</tr>
				<tr>
					<td>Title</td>
					<td><form:input path="title" size="55" /> </td>
					<td rowspan="6">
						<div id="imageplaceholder">
							
						</div>
					</td>
				</tr>
				<tr>
					<td>Image</td>
					<td><form:input path="imagePath" id="imageurlManual"  size="55" onchange="showImage('imageurlManual')" disabled="false"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<!-- <input type="file" id="imageurlBrowse" name="imageFile" disabled="true">   -->
						<input type="hidden" name="imageFile">
						<form:hidden path="itemId"/>
						<form:hidden path="entryDate"/>
					</td>
				</tr>
				
				<!--  
				<tr>
					<td></td>
					<td>
						Option <input type="radio" value="Manual" name="imageUploadOption" checked="checked" onclick="enableField('imageurlManual','imageurlBrowse')">Manual Entry <input type="radio" value="Browse" name="imageUploadOption" onclick="enableField('imageurlBrowse','imageurlManual')">Browse FileSystem
					</td>
				</tr>
				
				-->
				<tr>
					<td>Category</td>
					<td>
						<form:select path="category" id="category">
							<c:forEach items="${allCategories}" var="category">
								<c:if test="${item.category.name ==  category.name}">
									<form:option selected="selected" value="${category.name}" title="${category.name}">${category.name}</form:option>
								</c:if>
								<c:if test="${item.category.name !=  category.name}">
									<form:option value="${category.name}" title="${category.name}">${category.name}</form:option>
								</c:if>
								
							</c:forEach>
						</form:select>
					</td>
					
				</tr>
				<tr>
					<td>Cost Price</td>
					<td>
						<form:input path="costPrice" id="costPrice"/> 
						<form:errors path="costPrice" cssClass="error-invalid"/>
					</td>
				</tr>
				<tr>
					<td>Selling Price</td>
					<td>
						<form:input path="sellingPrice" id="sellingPrice"/>
						<form:errors path="sellingPrice" cssClass="error-invalid"/> 
					</td>
				</tr>		
				<tr>
					<td>Supplier</td>
					<td><form:input path="supplier"/> </td>
				</tr>
				<tr>
					<td>Entry Date</td>
					<td>${item.entryDate}</td>
				</tr>
				<tr>
					<td>Description</td>
					<td><form:textarea cols="50" rows="10" path="description"/> </td>
				</tr>
				<tr>
					<td>Comments</td>
					<td><form:textarea cols="50" rows="10" path="comments"/> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Update Item" onclick="return checkFormData()"/>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>