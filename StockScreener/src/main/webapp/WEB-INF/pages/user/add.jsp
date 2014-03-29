<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Manager</title>

<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet" type="text/css" >
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.10.4.js" />" ></script>

<script type="text/javascript">
	var strings = new Array();
	strings['recaptcha.instructions_visual'] = "<spring:message code='recaptcha.instructions_visual' javaScriptEscape='true'/>";
	strings['recaptcha.instructions_audio'] = "<spring:message code='recaptcha.instructions_audio' javaScriptEscape='true'/>"; 
	strings['recaptcha.play_again'] = "<spring:message code='recaptcha.play_again' javaScriptEscape='true'/>";
	strings['recaptcha.cant_hear_this'] = "<spring:message code='recaptcha.cant_hear_this' javaScriptEscape='true'/>";
	strings['recaptcha.visual_challenge'] = "<spring:message code='recaptcha.visual_challenge' javaScriptEscape='true'/>";
	strings['recaptcha.audio_challenge'] = "<spring:message code='recaptcha.audio_challenge' javaScriptEscape='true'/>";
	strings['recaptcha.refresh_btn'] = "<spring:message code='recaptcha.refresh_btn' javaScriptEscape='true'/>"; 
	strings['recaptcha.help_btn'] = "<spring:message code='recaptcha.help_btn' javaScriptEscape='true'/>";
	strings['recaptcha.incorrect_try_again'] = "<spring:message code='recaptcha.incorrect_try_again' javaScriptEscape='true'/>";

	var RecaptchaOptions = {
	custom_translations : {		 
		 instructions_visual :  strings['recaptcha.instructions_visual'] ,
		 instructions_audio : strings['recaptcha.instructions_audio'],
		 play_again : strings['recaptcha.play_again'],
		 cant_hear_this : strings['recaptcha.cant_hear_this'],
		 visual_challenge : strings['recaptcha.visual_challenge'],
		 audio_challenge : strings['recaptcha.audio_challenge'],
		 refresh_btn : strings['recaptcha.refresh_btn'],
		 help_btn : strings['recaptcha.help_btn'],
		 incorrect_try_again : strings['recaptcha.incorrect_try_again']
	},		 
	theme : 'clean'
	}; 
</script>

</head>
<body> 

<h1>Add User</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/add/process.html">
<div>${message}</div>
<table>
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
        <td><form:errors path="userName" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td>Password :</td>
        <td><form:password path="password" /></td>
        <td><form:errors path="password" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="email">Email :</form:label></td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" cssClass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="telephone">Telephone :</form:label></td>
        <td><form:input path="telephone" /></td>
        <td><form:errors path="telephone" cssClass="error"></form:errors></td> 
    </tr>
    <tr>
        <td><form:label path="address">Address :</form:label></td>
        <td><form:textarea path="address" /></td>
    </tr>
</table>

<div id="captcha_paragraph">
            <c:if test="${invalidRecaptcha == true}">
                <span class="error_form_validation">type here</span>
            </c:if>
            <%
                ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LcW3OASAAAAAKEJTHMmp_bo5kny4lZXeDtgcMqC", 
                                    "6LcW3OASAAAAAKVX2duVsSy2uMMHL105-jPDrHMD", false);
                out.print(c.createRecaptchaHtml(null, null));
            %>                
        </div>
        <div>${messageRecaptcha}</div>
<table>     
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