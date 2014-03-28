<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 

<h1>Add team page</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandName="intradayShareData" action="${pageContext.request.contextPath}/intradaysharedata/add/process.html">
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