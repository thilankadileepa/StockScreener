<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Daily Share Data Registration</title>
</head>
<body>
<h2>Daily Share Data Manager</h2>
<form:form method="post" action="addDailyShareData.htm">
 
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
</body>
</html>