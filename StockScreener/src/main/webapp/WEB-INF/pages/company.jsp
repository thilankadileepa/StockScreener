<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Company Registration</title>
</head>
<body>
<h2>Company Manager</h2>
<form:form method="post" commandname="sector" action="addCompany.htm">
 
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
        <td colspan="2">
            <input type="submit" value="Save"/>
        </td>
    </tr>
</table> 
     
</form:form>
</body>
</html>