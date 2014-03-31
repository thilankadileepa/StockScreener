<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Daily share data</title>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.10.4.js" />" ></script>
<link  href="<c:url value="/resources/css/jquery-ui-1.10.4.css" />" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	$(document).ready(function() {
	 	$( "#datepicker" ).datepicker({ dateFormat: "yy-mm-dd" });
	});

</script>
</head>
<body>
<h1>Edit daily share data</h1>
<p>Here you can edit the existing daily share data.</p>
<p>${message}</p>
<form:form method="POST" commandName="dailyShareData" action="${pageContext.request.contextPath}/dailysharedata/edit/${userCategory.id}.html">
<table>
    <tr>
    	<td>
    		Company :
    	</td>
	    <td>   
	        <form:select itemValue="id" itemLabel="name" path="company.id" items="${companyMap}">  
        	</form:select> 
	    </td> 
	</tr>
    <tr>
        <fmt:formatDate value="${dailysharedata.date}" var="dateString" pattern="yyyy-MM-dd" />
        <td><form:label path="date">Date :</form:label></td>
        <td><form:input path="date" value="${dateString}" id="datepicker" /></td>
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
    <tr><td><form:hidden  path="id" ></form:hidden></td></tr>
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