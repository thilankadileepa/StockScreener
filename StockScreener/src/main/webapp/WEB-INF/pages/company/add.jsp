<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company</title>
</head>
<body> 

<h1>Add Company </h1>
<p>Here you can add a new Company.</p>
<form:form method="POST" commandName="company" action="${pageContext.request.contextPath}/copmany/add/process.html">
 <table>
    <tr>
    	<td>
    		<form:label path="name">Sector :</form:label>
    	</td>
	    <td>   
	        <form:select path="sector" items="${sectorsMap}">  
        	</form:select> 
	    </td> 
	</tr>
    <tr>
        <td><form:label path="name">Name :</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="code">Code :</form:label></td>
        <td><form:input path="code" /></td>
    </tr>
    <tr>
    	<td>
    		<form:label path="name">Large Cap Company :</form:label>
    	</td>
	    <td>   
	        <form:select path="sector" items="${lagrgcap}">  
        	</form:select> 
	    </td> 
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