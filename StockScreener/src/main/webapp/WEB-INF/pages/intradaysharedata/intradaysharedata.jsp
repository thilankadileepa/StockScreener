<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>IntraDay Share Data Registration</title>
</head>
<body>
<h2>IntraDay Share Data Manager</h2>
<form:form method="post" action="addIntraDayShareData.htm">
 
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
</body>
</html>