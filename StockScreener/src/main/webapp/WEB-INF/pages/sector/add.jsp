<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sector</title>
</head>
<body> 

<h1>Add Sector</h1>
<p>Here you can add a new sector.</p>
<form:form method="POST" commandName="sector" action="${pageContext.request.contextPath}/sector/add/process.html">
<div>${message}</div>
 <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
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

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>