<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 

<h1>Add team page</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandName="filterCategory" action="${pageContext.request.contextPath}/filtercategory/add/process.html">
<table>
<tbody>
	<tr>
		<td>Name:</td>
		<td><form:input path="filterType"></form:input></td>
	</tr>	
	<tr>
		<td><input value="Add" type="submit"></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>