<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>QuarterlyShareData Registration</title>
</head>
<body>
<h2>QuarterlyShareData Manager</h2>
<form:form method="post" action="addQuarterlyShareData.htm">
 
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
        <td><form:label path="quarterCode">Quarter Code :</form:label></td>
        <td><form:input path="quarterCode" /></td>
    </tr>
    <tr>
        <td><form:label path="profit">Profit :</form:label></td>
        <td><form:input path="profit" /></td>
    </tr>
    <tr>
        <td><form:label path="weightedAverage">Weighted Average :</form:label></td>
        <td><form:input path="weightedAverage" /></td>
    </tr>
    <tr>
        <td><form:label path="averageEquity">Average Equity :</form:label></td>
        <td><form:input path="averageEquity" /></td>
    </tr>
    <tr>
        <td><form:label path="averageTotalAsse">Average Total Assert :</form:label></td>
        <td><form:input path="averageTotalAsse" /></td>
    </tr>
    <tr>
        <td><form:label path="profitAfterTax">Profit After Tax :</form:label></td>
        <td><form:input path="profitAfterTax" /></td>
    </tr>
    <tr>
        <td><form:label path="ebitda">EBITDA :</form:label></td>
        <td><form:input path="ebitda" /></td>
    </tr>
     <tr>
        <td><form:label path="cash">Cash :</form:label></td>
        <td><form:input path="cash" /></td>
    </tr>
    <tr>
        <td><form:label path="percentOwnbyInsiders">Percent Own by Insiders :</form:label></td>
        <td><form:input path="percentOwnbyInsiders" /></td>
    </tr>
    <tr>
        <td><form:label path="instOwnership">InstOwnership :</form:label></td>
        <td><form:input path="instOwnership" /></td>
    </tr>
    <tr>
        <td><form:label path="sharesInFreefloat">Shares In Free float :</form:label></td>
        <td><form:input path="sharesInFreefloat" /></td>
    </tr>
    <tr>
        <td><form:label path="debt">DEBT :</form:label></td>
        <td><form:input path="debt" /></td>
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