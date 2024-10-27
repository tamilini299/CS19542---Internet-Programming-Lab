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

	<table id="horseInfo" width="80%" align="center" border="1">	
		<tr><td colspan="2"><%@ include file="header.jsp" %></td></tr>
		<tr><td width="35%"><%@ include file="navigation.jsp" %></td>
	
		<td><form name="placeBet" action="/play/bet" method="post">
			<input type="hidden" name="userId" value="${userInfo.userId}" />
			<input type="hidden" name="firstName" value="${userInfo.firstName}" />
				
			<table width="80%" align="center">
				<c:set var="count" value="0" scope="page" />
				
				<tr><td align="center" colspan="3">
					<b>Place Your Bet</b><hr />
						<br />
						<div id="errDiv" class="errDiv" style="${errStyle}">${errorInfo}</div><br /></td></tr>
				<tr><td><br /></td></tr>
					
				
	                <c:forEach items="${horseInfo}" var="hInfo">
	                <tr>
	                    <c:set var="count" value="${count + 1}" scope="page"/>
	                    
	                    <c:choose>	                    
				    		<c:when test="${betInfo.wonHorse == count}">
				    			<c:set var="block" value="block" scope="page"/>	
				    			<c:set var="wonDiv" value="id=\"wonDiv\"" scope="page"/>			    			
				    		</c:when>				    	
					    	<c:otherwise>
					    		<c:set var="block" value="none" scope="page"/>
					    		<c:set var="wonDiv" value="" scope="page"/>	
					    	</c:otherwise>				    	
				    	</c:choose>
	                    
	                    <td><img src="../images/horse-${count}.gif" width="80" height="50" /></td>
	                    <td align="center"><b>${hInfo.horseName}</b></td>	                    
	                    <td><input type="radio" value="${count}" name="horseId" onchange="disableErrorMsg()"/></td>
	                    <td><span ${wonDiv} style="display:${block};border: 2px solid blue;text-align:center" class="wonDiv"><b>WON</b></span></td>
	                   </tr> 
	                </c:forEach>  
	              
			
				<tr><td><br /></td></tr>
			
				<tr><td><b>Bet Amount</b></td>				
					<td colspan="3"><input type="text" name="betAmount" id="betAmount" onkeyup="disableErrorMsg()" /></td></tr>
				<tr><td><br /></td></tr>
				
				<tr><td><br /></td></tr>
				<tr><td>&nbsp;</td><td colspan="3">
					<span><input class="buttons" type="button" onclick="playBet()" value="Place Your Bet"/></span>
				</td></tr>
			</table>
			
		</form></td></tr>
	</table>
</body>
</html>