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
<form:form method="POST" commandName="intradayShareData" action="${pageContext.request.contextPath}/intradaysharedata/edit/${intradayShareData.id}.html">
<table>
    <tr>
    	<td>
    		<form:label path="company">Company :</form:label>
    	</td>
	    <td>   
	        <form:select path="company" items="${companyMap}">  
        	</form:select> 
	    </td> 
	</tr>
    <tr>
        <td><form:label path="time">Date :</form:label></td>
        <td><form:input path="time" id="datepicker" /></td>
    </tr>
    <tr>
        <td><form:label path="tradeVolume">Trade Volume :</form:label></td>
        <td><form:input path="tradeVolume" /></td>
    </tr>
    <tr>
        <td><form:label path="shareVolume">Share Volume :</form:label></td>
        <td><form:input path="shareVolume" /></td>
    </tr>
    <tr>
        <td><form:label path="turnover">Turnover :</form:label></td>
        <td><form:input path="turnover" /></td>
    </tr>
    <tr>
        <td><form:label path="lastTradedPrice">Last Traded Price :</form:label></td>
        <td><form:input path="lastTradedPrice" /></td>
    </tr>
    <tr>
        <td><form:label path="closingPrice">Closing Price :</form:label></td>
        <td><form:input path="closingPrice" /></td>
    </tr>
    <tr>
        <td><form:label path="valueChange">Value Change :</form:label></td>
        <td><form:input path="valueChange" /></td>
    </tr>
     <tr>
        <td><form:label path="percentageChange">Percentage Change :</form:label></td>
        <td><form:input path="percentageChange" /></td>
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