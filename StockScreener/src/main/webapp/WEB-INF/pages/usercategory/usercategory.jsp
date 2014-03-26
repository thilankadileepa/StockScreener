<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h2>User Category Manager</h2>
<form:form method="post" action="addUserCategory.htm">
 
    <table>
    <tr>
        <td><form:label path="name">User Name</form:label></td>
        <td><form:input path="name" /></td>
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