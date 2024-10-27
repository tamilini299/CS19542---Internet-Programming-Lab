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
   	
	<table id="cardInfo" width="80%" align="center" border="1">	
		<tr><td colspan="2"><%@ include file="header.jsp" %></td></tr>
		<tr><td width="35%"><%@ include file="navigation.jsp" %></td>
	
		<td>
			<form name="cardInfoForm" id="cardInfoForm" action="/balance/update" method="post" modelAttribute="cardForm">
			<input type="hidden" name="userId" id="userId" value="${userInfo.userId}" />
			<input type="hidden" name="firstName" value="${userInfo.firstName}" />
			
			<table width="90%" align="center">
				<tr><td colspan="2" align="center">
					<b>Make Your Payment</b><hr /><br />
					<div id="errDiv" class="errDiv" style="${errStyle}">${errorInfo}</div><br /></td></tr>
				
				<tr><td><b>Card Holder Name</b></td><td>
						<input type="hidden" name="cardOwner" value="${cardInfo.cardOwner}">
						${cardInfo.cardOwner}</td></tr>
						<tr><td><br /></td></tr>
			
				<tr><td><b>Card Number</b></td><td>
					<input type="hidden" name="cardNumber" value="${cardInfo.cardNumber}">
					${cardInfo.cardNumber}</td></tr>
						<tr><td><br /></td></tr>
				
				<tr><td><b>Card Expiry</b></td><td>
					<input type="hidden" name="cardExpiry" value="${cardInfo.cardExpiry}">
					${cardInfo.cardExpiry}</td></tr>
						<tr><td><br /></td></tr>
		
				<c:choose>
				    <c:when test="${empty errorInfo}">			    
						<tr><td><b>Amount to Pay</b></td><td>
								<input type="text" id="balance" name="balance" onkeyup="disableErrorMsg()" />
								
								<tr><td><br /></td></tr>		
				
						<tr><td align="center" colspan="2">
							<input class="buttons" type="button" onclick="makePayment()" value="Pay" /></td></tr>						
					</c:when>					
				    <c:otherwise>
						<tr><td><b>Amount to Pay</b></td><td>
							<input type="text" id="balance" name="balance" onkeyup="disableErrorMsg()" disabled/>
								
						<tr><td><br /></td></tr>				
						<tr><td align="center" colspan="2">
							<input class="buttons-card" type="button" value="Pay" disabled/></td></tr>						
					</c:otherwise>
				</c:choose>
				
				<tr><td><br /><br /></td></tr>
			</table></form>
		</td></tr></table>

</body>
</html>