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

		<table>
			<tr>
				<th>TimeStamp</th>
				<th>PhoneNumber</th>
				<th>Identity</th>
				<th>Reputation</th>
				<th>CallDirection</th>
			</tr>
		<%
      		for (int i = 0; i < data.length; i++) {
            		CallInformation c = data[i];
		%>
			<tr>
				<td><%=Long.toString(c.getTime())%></td>
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

