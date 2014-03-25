<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit module page</title>
</head>
<body>
<h1>Edit module page</h1>
<p>Here you can edit the existing module.</p>
<p>${message}</p>
<form:form method="POST" commandName="module" action="${pageContext.request.contextPath}/module/edit/${module.id}.html">
	<table>
	    <tr>
	        <td><form:label path="name">Name</form:label></td>
	        <td><form:input path="name" /></td>
	    </tr>
	    <tr>
	        <td colspan="2">
	            <input type="submit" value="Edit"/>
	        </td>
	    </tr>
	    <tr>
	        <td><form:hidden path="id"></form:hidden></td>
	    </tr>
	</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>