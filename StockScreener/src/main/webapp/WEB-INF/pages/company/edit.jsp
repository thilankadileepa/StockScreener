<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Company</title>
<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet" type="text/css" >
</head>
<body>
<h1>Edit team page</h1>
<p>Here you can edit the existing team.</p>
<p>${message}</p>
<form:form method="POST" commandName="company" action="${pageContext.request.contextPath}/company/edit/${company.id}.html">
<div>${message}</div>
 <table>
    <tr>
    	<td>
    		<form:label path="name">Sector :</form:label>
    	</td>
	    <td>   
	        <form:select itemValue="id" itemLabel="name" path="sector.id" items="${sectorsMap}">  
        	</form:select> 
	    </td> 
	</tr>
    <tr>
        <td><form:label path="name">Name :</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="code">Code :</form:label></td>
        <td><form:input path="code" /></td>
    </tr>
   <tr>
    	<td>
    		<form:checkbox path="largeCap" itemLabel="id" itemValue="name" value="1"/>Large cap
    	</td>
	    <td>   
	        <form:checkbox path="asi" itemLabel="id" itemValue="name" value="1"/>ASI
	    </td> 
	    <td>   
	        <form:checkbox path="snp" itemLabel="id" itemValue="name" value="1"/>S&P
	    </td>
	</tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Save"/>
        </td>
    </tr>
</table> 
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>
