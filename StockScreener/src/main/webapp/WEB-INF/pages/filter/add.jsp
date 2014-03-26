<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filter</title>
</head>
<body> 

<h1>Add Filter </h1>
<p>Here you can add a new filter.</p>
<form:form method="POST" commandName="filter"  action="${pageContext.request.contextPath}/filter/add/process.html">
	 <table>
	    <tr>
	    	<td>Filter Category :</td>
		    <td>
		    	<form:select itemValue="id" itemLabel="filterType" path="filterCategory.id" items="${filterCategoriesMap}">  
	        	</form:select>
		    </td> 
		</tr>
		<tr>
	    	<td>Module :</td>
		    <td> 
		    	<form:select itemValue="id" itemLabel="name" path="module.id" items="${moduleMap}">  
	        	</form:select> 
		    </td> 
		</tr>
	    <tr>
	        <td><form:label path="filterValues">Filter Value :</form:label></td>
	        <td><form:input path="filterValues" /></td>
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