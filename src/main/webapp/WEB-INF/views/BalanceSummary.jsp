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

	<table id="balSummary" width="80%" align="center" border="1">	
		<tr><td colspan="2"><%@ include file="header.jsp" %></td></tr>
		<tr><td width="35%"><%@ include file="navigation.jsp" %></td>

		<td><table width="80%" align="center">
				<tr><td align="center" colspan="2">
				<div id="errDiv" class="errDiv" style="${errStyle}">${errorInfo}</div><br />
						<b>Balance Summary</b><hr /><br /></td></tr>
				<tr><td><br /></td></tr></table>

			<table width="80%" align="center" border="1">
 				<c:choose>
		    		<c:when test="${empty errorInfo}">
		    			<tr><td><b>First Name</b></td><td><b>Balance</b></td></tr>
		    		</c:when>		    	
		    	</c:choose>		    	

                <c:forEach items="${summaryInfo}" var="sInfo">
                    <tr>
                    	<td>${sInfo.firstName}</td>
                    	<td>${sInfo.balance}</td>
                    </tr>
                </c:forEach>
			</table>
		</td></tr>
	</table>
</body>
</html>