<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Call Log</title>
	</head>
	<body>
	    <%@ page import="java.util.List" %>
		<%@ page import="databeans.CallInformation" %>
		<% List<List<CallInformation>> data = (List<List<CallInformation>>) request.getAttribute("data"); %>

		<%
      		for (int i = 0; i < data.size(); i++) {
      			List<CallInformation> callsToday = data.get(i);
      	%>
      		<h3><%=callsToday.get(0).getFormattedDate() %></h3>
      		<table style="table-layout:fixed">
		    <col width="150">
		    <col width="120">
		    <col width="150">
		    <col width="120">
		    <col width="120">
			<tr>
				<th align="left">Time</th>
				<th align="left">PhoneNumber</th>
				<th align="left">Identity</th>
				<th align="left">Reputation</th>
				<th align="left">CallDirection</th>
			</tr>
      		<%
      			for (int j = 0; j < callsToday.size(); j++){
      				CallInformation c = callsToday.get(j);
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
		<%
      		}
		%>
	</body>
</html>

