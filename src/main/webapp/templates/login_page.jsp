
<form name="loginForm" id="loginForm" action="/user/login" method="post" modelAttribute="userForm">

	
	<table width="50%" align="center">
	
		<tr><td><br /></td></tr>
		<tr><td align="center" colspan="2"><b><h3>Race Track Wagers</h3></b><hr /></td></tr>
				<tr><td><br /></td></tr>
				
		<tr><td><b>User Name:</b></td><td><input type="text" id="userName" name="userName" value="admin" size="20" onkeyup="disableErrorMsg()" /></td></tr>
				<tr><td><br /></td></tr>

		<tr><td><b>Password:</b></td><td><input type="password" id="password" name="password" value="admin" size="20" onkeyup="disableErrorMsg()"/></td></tr>
		
		<tr><td><br /><br /><br /></td></tr>
		
		<!-- tr><td align="center" colspan="2"><input class="buttons" type="button"  onClick="authenticate()" value="Login" id="loginBtn"/-->
		<tr><td align="center" colspan="2"><input class="buttons" type="Submit"  value="Login" id="loginBtn"/>
		
		<input class="buttons-link" type="button" onclick="changeMainDiv('register_form.jsp')" value="Create Account" id="createBtn" /></td></tr>
		
		<tr><td><br /><br /></td></tr>
	</table>
</form>