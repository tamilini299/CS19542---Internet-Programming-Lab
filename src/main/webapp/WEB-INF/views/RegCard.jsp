<%@ include file="utilPage.jsp" %>

<html>
<head>
	<%@ include file="head.jsp" %>
</head>

<body>

	<c:choose>	                    
   		<c:when test="${errorInfo != null}">
   			<c:set var="errStyle" value="display:block;border: 1px solid" scope="page"/>	
   		</c:when>
   	</c:choose>

	<div id="cardDiv">	
		<form name="cardForm" id="cardForm" action="/register/card" method="post" modelAttribute="cardForm">
		<input type="hidden" name="userId" id="userId" value="${userInfo.userId}" />
		<input type="hidden" name="firstName" value="${userInfo.firstName}" />
		
				<table width="50%" align="center">
					<tr><td align="center" colspan="3"><b><h3>Card Registration</h3></b><hr /></td></tr>
				
					<tr><td align="center" colspan="3">
						<div id="errDiv" class="errDiv" style="${errStyle}">${errorInfo}</div><br /><br /></td></tr>
					
					<tr><td><b>Card Holder Name</b></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><input pattern="[a-zA-Z]+" type="text" name="cardOwner" id="cardOwner" value="owner" onkeyup="disableErrorMsg()" /></td></tr>
						<tr><td><br /></td></tr>
				
					<tr><td><b>Card Number</b></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><input type="text" name="cardNumber" id="cardNumber" maxlength="19" value="1111-2222-3333-4444" onkeyup="disableErrorMsg()" /></td></tr>
						<tr><td><br /></td></tr>
					
					<tr><td><b>Card Expiry</b></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><input type="text" name="cardExpiry" id="cardExpiry" maxlength="5" value="12/22" onkeyup="disableErrorMsg()" /><br />
							<span class="cardFormat">( MM / DD )</span></td></tr>
						<tr><td><br /></td></tr>
	
					<tr><td><b>CVV</b></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><input type="number" name="cardCVV" id="cardCVV" maxlength="3" value="123" onkeyup="disableErrorMsg()" /></td></tr>
						<tr><td><br /></td></tr>
						
						<tr><td><br /></td></tr>
						
					<tr><td align="center" colspan="3">
						<input class="buttons" type="button" onclick="submitCard()" value="Register" /></td></tr>

					<tr><td><br /><br /></td></tr>
				</table>
			</form>
		</div>
</body>
</html>