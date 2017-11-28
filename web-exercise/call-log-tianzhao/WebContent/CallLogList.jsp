<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Call Log</title>
	</head>
	<body>
		<%@ page import="databeans.CallInformation" %>
		<% CallInformation[] data = (CallInformation[]) request.getAttribute("data"); %>

		<table style="table-layout:fixed">
		    <col width="150">
		    <col width="120">
		    <col width="150">
		    <col width="120">
		    <col width="120">
			<tr>
				<th align="left">TimeStamp</th>
				<th align="left">PhoneNumber</th>
				<th align="left">Identity</th>
				<th align="left">Reputation</th>
				<th align="left">CallDirection</th>
			</tr>
		<%
      		for (int i = 0; i < data.length; i++) {
            		CallInformation c = data[i];
		%>
			<tr>
				<td><%=c.getFormattedTime()%></td>
				<td><%=c.getPhoneNumber()%></td>
				<%
					if (c.getIdentity() == null) {
				%>
					<td>Unknown</td>
				<%
					} else {
				%>
					<td><%=c.getIdentity()%></td>
				<%	
					}
				%>
				
				<%
					if (c.getReputation() == null) {
				%>
					<td>Unknown</td>
				<%
					} else {
				%>
					<td><%=c.getReputation()%></td>
				<%	
					}
				%>
				
				<td><%=c.getCallDirection()%></td>
			</tr>
		<%
      		}
		%>
		</table>
	</body>
</html>

