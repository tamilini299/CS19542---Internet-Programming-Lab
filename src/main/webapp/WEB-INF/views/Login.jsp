<%@ include file="utilPage.jsp" %>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Spring Boot Race Tracker</title>
	<%@ include file="head.jsp" %>
</head>
<body>

    <c:choose>	                    
   		<c:when test="${errorInfo != null}">
   			<c:set var="errStyle" value="display:block;border: 1px solid" scope="page"/>	
   		</c:when>
   	</c:choose>

	<form name="loginForm" id="loginForm" action="/user/login" method="post" modelAttribute="userForm">	
		
		<h3 class="mainHeader">Race Track Wagers</h3><hr />
		<table width="50%" align="center" class="loginTable">		

			<tr><td align="center" colspan="2"><div id="errDiv" class="errDiv" style="${errStyle}">${errorInfo}</div></td></tr>
				<tr><td><br /></td></tr>
					
			<tr><td><b>User Name</b></td><td><input type="text" id="userName" name="userName" value="admin" size="20" onkeyup="disableErrorMsg()" /></td></tr>
				<tr><td><br /></td></tr>
	
			<tr><td><b>Password</b></td><td><input type="password" id="password" name="password" value="admin" size="20" onkeyup="disableErrorMsg()"/></td></tr>
				<tr><td><br /><br /><br /></td></tr>
			
			<tr><td align="center" colspan="2"><input class="buttons-login" type="button" onClick="authenticate()" value="Login"/></td></tr>
				<tr><td><br /><br /><br /></td></tr>
			
			<tr><td colspan="2"><span class="regText">First Time User?.</span>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/get/regform" class="createText">Create Account</a></td></tr>			
				<tr><td><br /><br /></td></tr>
				
		</table>
	</form>
</body>
</html>