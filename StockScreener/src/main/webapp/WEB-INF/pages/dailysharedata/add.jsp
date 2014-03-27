<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 

<h1>Add team page</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandName="dailysharedata" action="${pageContext.request.contextPath}/dailysharedata/add/process.html">
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