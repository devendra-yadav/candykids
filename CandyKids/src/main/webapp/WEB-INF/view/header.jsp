<%@ include file="taglibs.jsp" %>
<center>
	<img
		src="${pageContext.request.contextPath}/resources/images/app/ck.jpg">
</center>
<!-- Following div is to show welcome message and 2 buttons for home and logout -->
<div align="right">
	Welcome	<security:authentication property="principal.username" />
	<table>
		<tr>
			<td><form:form method="GET"	action="${pageContext.request.contextPath}/">
					<input type="submit" class="submit" value="Home" />
				</form:form></td>

			<td><form:form method="POST" action="${pageContext.request.contextPath}/logout">
					<input type="submit" class="submit" value="LogOut" />
				</form:form></td>
		</tr>
	</table>
</div>