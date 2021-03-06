<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User Category List</title>
</head>
<body>
<h1>List of user category</h1>
<p>Here you can see the list of the user category, edit them, remove or update.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
</thead>
<tbody>
<c:forEach var="userCategory" items="${userCategories}">
<tr>
	<td>${userCategory.id}</td>
	<td>${userCategory.name}</td>	
	<td>
	<a href="${pageContext.request.contextPath}/usercategory/edit/${userCategory.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/usercategory/delete/${userCategory.id}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/usercategory/add.html">Add User Category</a></p>
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>