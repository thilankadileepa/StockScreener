<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Daily Sector Data List</title>
</head>
<body>
<h1>List of Daily Sector Data</h1>
<p>Here you can see the list of the daily sector data, edit them, remove or update.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
</thead>
<tbody>
 
<c:forEach var="dailysectordata" items="${dailysectordata}">
<tr>
	<td>${dailysectordata.id}</td>
	<td>${dailysectordata.date}</td>
	<td>${dailysectordata.closingValue}</td>
	<td>${dailysectordata.noOfTrades}</td>	
	<td>${dailysectordata.volume}</td>	
	<td>${dailysectordata.turnOver}</td>			
	<td>
	<a href="${pageContext.request.contextPath}/dailysectordata/edit/${dailysectordata.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/dailysectordata/delete/${dailysectordata.id}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>