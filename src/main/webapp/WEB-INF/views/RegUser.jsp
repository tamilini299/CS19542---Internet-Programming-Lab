<%@ include file="utilPage.jsp" %>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User Registration Form</title>
	<%@ include file="head.jsp" %>
</head>
<body>

    <c:choose>	                    
   		<c:when test="${errorInfo != null}">
   			<c:set var="errStyle" value="display:block;border: 1px solid" scope="page"/>	
   		</c:when>
   	</c:choose>

	<div align="center">
	<form name="regForm" id="regForm" 
		  action="/register/user" method="post" modelAttribute="regForm">	
		
		<table width="50%" align="center">
			<tr><td align="center" colspan="3"><b><h3>User Registration</h3></b><hr /></td></tr>
			
 			<tr><td align="center" colspan="3"><div id="errDiv" class="errDiv" style="${errStyle}">${errorInfo}</div><br /><br /></td></tr>
			
			<tr><td><b>First Name</b></td>
				<td>&nbsp;</td>
				<td><input type="text" name="firstName" id="firstName" value="first" size="30" onkeyup="disableErrorMsg()" /></td></tr>
					<tr><td><br /></td></tr>
		
			<tr><td><b>Last Name</b></td>
				<td>&nbsp;</td>
				<td><input type="text" name="lastName" id="lastName" value="last" size="30" onkeyup="disableErrorMsg()"/></td></tr>
					<tr><td><br /></td></tr>
			
			<tr><td><b>User Name</b></td>
				<td>&nbsp;</td>
				<td><input type="text" name="userName" id="userName" value="admin" size="25" onkeyup="disableErrorMsg()" /></td></tr>
					<tr><td><br /></td></tr>
		
			<tr><td><b>Password</b></td>
				<td>&nbsp;</td>
				<td><input type="password" name="password" id="password" value="admin" size="25" onkeyup="disableErrorMsg()"/></td></tr>
					<tr><td><br /></td></tr>
			
			<tr><td><b>Mobile Number</b></td>
				<td>&nbsp;</td>
				<td><input type="text" name="mobileNum" id="mobileNum" value="1234567890" size="15" length="10" onkeyup="disableErrorMsg()" /></td></tr>
					<tr><td><br /></td></tr>
		
			<tr><td><b>Email Address</b></td>
				<td>&nbsp;</td>
				<td><input type="text" name="emailId" id="emailId" value="admin@email.com" size="30" onkeyup="disableErrorMsg()"/></td></tr>	
				<tr><td><br /></td></tr>
			
			<tr><td align="center" colspan="3"><input class="buttons" type="button" onclick="regUser()" value="Next"/>
					
			<tr><td><br /><br /></td></tr>
		</table>
	</form>
	</div>
</body>
</html>