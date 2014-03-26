<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Intraday Sector Data Registration</title>
</head>
<body>
<h2>Intraday Sector Data Manager</h2>
<form:form method="post" action="addIntradaySectorData.htm">
 
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
        <td><form:label path="time">Time :</form:label></td>
        <td><form:input path="time" id="datepicker" /></td>
    </tr>
    <tr>
        <td><form:label path="value">Value :</form:label></td>
        <td><form:input path="value" /></td>
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
        <td><form:label path="sequence">Sequence :</form:label></td>
        <td><form:input path="sequence" /></td>
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