<%@ include file="utilPage.jsp" %>

<head>
	<%@ include file="head.jsp" %>
</head>

<body>

    <c:choose>	                    
   		<c:when test="${errorInfo != null}">
   			<c:set var="errStyle" value="display:block;border: 1px solid" scope="page"/>	
   		</c:when>
   	</c:choose>
   	
	<table id="addHorseDiv" width="80%" align="center" border="1">	
		<tr><td colspan="2"><%@ include file="header.jsp" %></td></tr>
		<tr><td width="35%"><%@ include file="navigation.jsp" %></td>
	
		<td><form name="addHorse" id="addHorse" action="/register/horse" method="post" modelAttribute="horseForm">
			<input type="hidden" name="userId" value="${userInfo.userId}" />
			<input type="hidden" name="firstName" value="${userInfo.firstName}" />
				
			<table width="80%" align="center">
				<c:set var="count" value="0" scope="page" />
				
				<tr><td align="center" colspan="3">
						<b>Add a New Horse</b><hr />
						<br />
						<div id="errDiv" class="errDiv" style="${errStyle}">${errorInfo}</div><br /></td></tr>
				<tr><td><br /></td></tr>
					
				<tr><td>Horse Name</td>				
					<td><input type="text" name="horseName" id="horseName" onkeyup="disableErrorMsg()" /></td></tr>
				<tr><td><br /></td></tr>
				
				<tr><td>Horse Owner</td>				
					<td><input type="text" name="horseOwner" id="horseOwner" onkeyup="disableErrorMsg()" /></td></tr>
				<tr><td><br /></td></tr>
				
				<tr><td colspan="2" align="center">
					<span><input class="buttons-addhorse" type="button" onclick="addHorseInfo()" value="Add"/></span>
				</td></tr>
			</table>
			
		</form></td></tr>
	</table>
</body>
</html>