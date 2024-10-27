<form id="navForm" action="" method="post" modelAttribute="navForm">
	<table width="100%" border="0">
	
		<tr><td>
			<input type="hidden" name="userId" value="${userInfo.userId}" />
			<input type="hidden" name="adminPass" id="adminPass" value="" />
			<input type="hidden" name="firstName" value="${userInfo.firstName}" />
			</td></tr>
			
		<tr><td align="center"><input class="buttons" onmouseup="disableErrorMsg()" type="button" onclick="submitDiv('card', 'navForm')" value="Add Balance"/></td></tr>
				<tr><td><br /></td></tr>

		<tr><td align="center"><input class="buttons" onmouseup="disableErrorMsg()" type="button" onclick="submitDiv('play', 'navForm')" value="Place Bet"/></td></tr>
				<tr><td><br /></td></tr>
		
		<tr><td align="center"><input class="buttons" onmouseup="disableErrorMsg()" type="button" onclick="submitDiv('balance', 'navForm')" value="View Balance"/></td></tr>	
				<tr><td><br /></td></tr>
				
		<tr><td align="center"><input class="buttons" onmouseup="disableErrorMsg()" type="button" onclick="submitDiv('horse', 'navForm')"" value="Add Horse"/></td></tr>	
				<tr><td><br /></td></tr>
				
		<tr><td align="center"><input class="buttons" onmouseup="disableErrorMsg()" id="viewSummary" type="button" value="View Summary"/></td></tr>	
				<tr><td><br /><br /></td></tr>
				
	</table>
</form>

<div id="dialogForm">
      <label for="name">Admin Password</label>
      <input type="password" id="passInput" class="text ui-widget-content ui-corner-all" />
</div>