<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit User</title>

<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet" type="text/css" >

</head>
<body>
<h1>Edit User</h1>
<p>Here you can edit the existing user.</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/edit/${user.id}.html">
<div>${message}</div>
<table>
    <tr>
        <td><form:label path="userName">User Name</form:label></td>
        <td><form:input path="userName" /></td>
        <td><form:errors path="userName" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="password">Password :</form:label></td>
        <td><form:password path="password" /></td>
        <td><form:errors path="password" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="email">Email :</form:label></td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="telephone">Telephone :</form:label></td>
        <td><form:input path="telephone" /></td> 
        <td><form:errors path="telephone" cssClass="error"></form:errors></td> 
    </tr>
    <tr>
        <td><form:label path="address">Address :</form:label></td>
        <td><form:textarea path="address" /></td>
    </tr>
     <tr>
        <td><form:hidden path="userCategory" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Edit"/>
        </td>
    </tr>
    <tr><td><form:hidden  path="id" ></form:hidden></td></tr>
</table> 
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>