<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Daily Share Data List</title>
</head>
<body>
<h1>List of Filters</h1>
<p>Here you can see the list of the daily share data, edit them, remove or update.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
</thead>
<tbody>
 
<c:forEach var="dailyShareData" items="${dailyShareDataList}">
<tr>
	<td>${dailyShareData.id}</td>
	<td>${dailyShareData.sharePrice}</td>	
	<td>${dailyShareData.high}</td>
	<td>${dailyShareData.low}</td>
	<td>${dailyShareData.volume}</td>
	<td>${dailyShareData.noOfTrade}</td>
	<td>${dailyShareData.openingPrice}</td>
	<td>
	<a href="${pageContext.request.contextPath}/dailysharedata/edit/${dailyShareData.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/dailysharedata/delete/${dailyShareData.id}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>