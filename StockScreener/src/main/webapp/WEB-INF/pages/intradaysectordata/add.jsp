<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 

<h1>Add team page</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandName="intradaysectordata" action="${pageContext.request.contextPath}/intradaysectordata/add/process.html">
 <table>
    <tr>
    	<td>
    		Sector :
    	</td>
	    <td>   
	        <form:select itemValue="id" itemLabel="name" path="sector.id" items="${sectorMap}">  
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

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>