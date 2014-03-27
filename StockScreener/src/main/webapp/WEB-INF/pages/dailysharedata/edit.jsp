<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit team page</title>
</head>
<body>
<h1>Edit team page</h1>
<p>Here you can edit the existing team.</p>
<p>${message}</p>
<form:form method="POST" commandName="dailyShareData" action="${pageContext.request.contextPath}/dailysharedata/edit/${userCategory.id}.html">
<table>
    <tr>
    	<td>
    		<form:label path="companyId">Company :</form:label>
    	</td>
	    <td>   
	        <form:select path="companyId" items="${companyMap}">  
        	</form:select> 
	    </td> 
	</tr>
    <tr>
        <td><form:label path="date">Date :</form:label></td>
        <td><form:input path="date" id="datepicker" /></td>
    </tr>
    <tr>
        <td><form:label path="sharePrice">Share Price:</form:label></td>
        <td><form:input path="sharePrice" /></td>
    </tr>
    <tr>
        <td><form:label path="high">High :</form:label></td>
        <td><form:input path="high" /></td>
    </tr>
    <tr>
        <td><form:label path="low">Low :</form:label></td>
        <td><form:input path="low" /></td>
    </tr>
    <tr>
        <td><form:label path="turnOver">Turnover :</form:label></td>
        <td><form:input path="turnOver" /></td>
    </tr>
    <tr>
        <td><form:label path="volume">Volume :</form:label></td>
        <td><form:input path="volume" /></td>
    </tr>
    <tr>
        <td><form:label path="noOfTrade">no Of Trade :</form:label></td>
        <td><form:input path="noOfTrade" /></td>
    </tr>
     <tr>
        <td><form:label path="openingPrice">Opening Price :</form:label></td>
        <td><form:input path="openingPrice" /></td>
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