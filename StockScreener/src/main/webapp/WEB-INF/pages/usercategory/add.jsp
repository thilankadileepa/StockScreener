<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet" type="text/css" >
<title>User Category - Add</title>
</head>
<body> 

<h1>Add User Category</h1>
<p>Here you can add a new user category.</p>
<form:form method="POST" commandName="userCategory" action="${pageContext.request.contextPath}/usercategory/add/process.html">
<table>
<tbody>
	<tr>
		<td>Name:</td>
		<td><form:input path="name"></form:input></td>
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