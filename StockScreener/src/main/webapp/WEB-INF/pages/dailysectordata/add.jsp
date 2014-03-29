<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Daily Sector Data</title>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.10.4.js" />" ></script>
<link  href="<c:url value="/resources/css/jquery-ui-1.10.4.css" />" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	$(document).ready(function() {
	 	$( "#datepicker" ).datepicker({ dateFormat: "yy-mm-dd" });
	});

</script>

</head>
<body> 

<h1>Daily Sector Data </h1>
<p>Here you can add a new daily sector data.</p>
<form:form method="POST" commandName="dailysectordata" action="${pageContext.request.contextPath}/dailysectordata/add/process.html">
 <table>
    <tr>
    	<td>
    		Sector :
    	</td>
	    <td>   
	        <form:select itemValue="id" itemLabel="name" path="sector.id"  items="${sectorsMap}">  
        	</form:select> 
	    </td> 
	</tr>
    <tr>
    <fmt:formatDate value="${dailysectordata.date}" var="dateString" pattern="yyyy-MM-dd" />
        <td><form:label path="date">Date :</form:label></td>
        <td><form:input path="date" id="datepicker" value="${dateString}" /></td>
    </tr>
    <tr>
        <td><form:label path="closingValue">Closing Value :</form:label></td>
        <td><form:input path="closingValue" /></td>
    </tr>
    <tr>
        <td><form:label path="noOfTrades">no Of Trades :</form:label></td>
        <td><form:input path="noOfTrades" /></td>
    </tr>
    <tr>
        <td><form:label path="volume">Volume :</form:label></td>
        <td><form:input path="volume" /></td>
    </tr>
    <tr>
        <td><form:label path="turnOver">Turnover :</form:label></td>
        <td><form:input path="turnOver" /></td>
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