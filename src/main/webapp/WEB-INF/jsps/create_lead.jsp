<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
	<h2>Create|New Lead</h2>
	
	<form action="saveLead" method="post">
		<pre>
		First Name<input type="text" name="firstName"/>
		Last Name<input type="text" name="lastName"/>
		Email<input type="email" name="email"/>
		Mobile<input type="number" name="mobile"/>
		Source:
		<select name="source" >
		  <option value="news paper">news paper</option>
		  <option value="online">online</option>
		  <option value="webinar">webinar</option>
		  <option value="radio">radio</option>
		</select>
		<input type="submit" value="save"/>
		</pre>
		</form>
		
	
</body>
</html>