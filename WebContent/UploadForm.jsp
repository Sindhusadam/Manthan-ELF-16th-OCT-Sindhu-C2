<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% String msg =(String)request.getAttribute("message") ;%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
<fieldset >
	<h4>Upload Resume</h4>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" size="50"> 
		<input type="submit" value="Upload">
	</form>
	<%if(msg != null && !msg.isEmpty()) { %>
	<h3 style="color: red"><%=msg %></h3>
	<%} %>
	<br>
	<br>
	<a href="http://localhost:8080/resumefinderapp/search1">Search Resume</a>
	</fieldset>
</body>
</html>