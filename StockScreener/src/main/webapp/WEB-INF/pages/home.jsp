<html>  
<head>  

<title>Being Java Guys | Hello World</title>  
</head>  
<body>  
<h1>Home page</h1>
<p>
${message}<br>
	<a href="${pageContext.request.contextPath}/usercategory/add.html">Add new User Category</a>
	<br>
	<a href="${pageContext.request.contextPath}/usercategory/list.html">User Category list</a>
	<br>
	<a href="${pageContext.request.contextPath}/user/add.html">Add new User</a>
	<br>
	<a href="${pageContext.request.contextPath}/user/list.html">User list</a>
	<br>
	<a href="${pageContext.request.contextPath}/sector/list.html">Sector list</a>
	<br>
	<a href="${pageContext.request.contextPath}/company/list.html">Company list</a>	
	<br>
	<a href="${pageContext.request.contextPath}/module/list.html">Module list</a>	
</p>
</body>
</html>