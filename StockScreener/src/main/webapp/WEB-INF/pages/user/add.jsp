<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Manage</title>
</head>
<body> 

<h1>Add User</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandName="user" modelattribute="validUser" action="${pageContext.request.contextPath}/user/add/process.html">
<table>
	<tr>
		<td>${message}</td>
	</tr>
	<tr>
    	<td>
    		User Category :
    	</td>
	    <td>   
	        <form:select itemValue="id" itemLabel="name" path="userCategory.id" items="${userCategoryMap}">  
        	</form:select> 
	    </td> 
	</tr>
    <tr>
        <td><label for="userNameInput">User Name</label></td>
        <td><form:input path="userName" /></td>
        <td><form:errors path="userName" cssclass="error"></form:errors></td>
    </tr>
    <tr>
        <td>Password :</td>
        <td><form:input path="password" /></td>
        <td><form:errors path="password" cssclass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="email">Email :</form:label></td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" cssclass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="telephone">Telephone :</form:label></td>
        <td><form:input path="telephone" /></td>
        <td><form:errors path="telephone" cssclass="error"></form:errors></td> 
    </tr>
    <tr>
        <td><form:label path="address">Address :</form:label></td>
        <td><form:textarea path="address" /></td>
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