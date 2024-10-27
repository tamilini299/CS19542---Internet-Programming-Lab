<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<head>
	<%@ include file="head.jsp" %>
</head>

<body>

	<table id="balanceMain" width="80%" align="center" border="1">	
		<tr><td colspan="2"><%@ include file="header.jsp" %></td></tr>
		<tr><td width="35%"><%@ include file="navigation.jsp" %></td>
	
		<td>		
			<table width="60%" align="center" id="balanceDiv">
							
				<tr><td align="center" colspan="3">
						<b>Your Balance Details</b><hr />
						<div id="errDiv" class="errDiv">${errorInfo}</div><br /></td></tr>
				<tr><td><br /><br /></td></tr>
					
				<tr><td>Hello <b>${userInfo.firstName}</b></td>
				<tr><td><br /></td></tr>
				
				<tr><td>Your Available Balance is <b>${balanceInfo.balance}</b></td>
				<tr><td><br /></td></tr>
			</table>
		
			<!-- div align="center" id="balanceDiv">
				<br />
				<b>Your Balance Details</b><br /><hr><br /><br /><br /><br />
				<p>Hello <b>${userInfo.firstName}</b></p> <br />
				<span>Your available Balance is </span> <b>${balanceInfo.balance}</b> 
				<br /><br /><br />   
				<br /><br /><br />  
				<br /><br />              
			</div-->
		</td></tr>
	</table>
</body>
</html>