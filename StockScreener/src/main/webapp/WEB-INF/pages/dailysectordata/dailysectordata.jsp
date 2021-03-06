<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Daily Sector Data Registration</title>
</head>
<body>
<h2>Daily Sector Data Manager</h2>
<form:form method="post" action="addDailySectorData.htm">
 
    <table>
    <tr>
    	<td>
    		<form:label path="sector">Sector :</form:label>
    	</td>
	    <td>   
	        <form:select path="sector" items="${sectorsMap}">  
        	</form:select> 
	    </td> 
	</tr>
    <tr>
        <td><form:label path="date">Date :</form:label></td>
        <td><form:input path="date" id="datepicker" /></td>
    </tr>
    <tr>
        <td><form:label path="closingValue">Closing Value :</form:label></td>
        <td><form:input path="closingValue" /></td>
    </tr>
    <tr>
        <td><form:label path="noOfTrades">no Of Trades :</form:label></td>
        <td><form:input path="noOfTrades" /></td>
    </tr>
    <tr>
        <td><form:label path="volume">Volume :</form:label></td>
        <td><form:input path="volume" /></td>
    </tr>
    <tr>
        <td><form:label path="turnOver">Turnover :</form:label></td>
        <td><form:input path="turnOver" /></td>
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