<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Daily Share Data</title>
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

<h1>Add daily share data page</h1>
<p>Here you can add a new daily share data.</p>
<form:form method="POST" commandName="dailysharedata" action="${pageContext.request.contextPath}/dailysharedata/add/process.html">
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