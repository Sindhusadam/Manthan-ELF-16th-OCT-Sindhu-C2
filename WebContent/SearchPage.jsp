<%@page import="java.io.File"  %>
<%@page import="java.util.ArrayList"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% ArrayList<File> array  =(ArrayList<File>)request.getAttribute("files");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
<form action="/search2" method="get" enctype="multipart/form-data">
<h3>Search Resume</h3>
<input type="text" name="search" required>
<input type="submit" value="submit">
<br>
<br>
<a href="http://localhost:8080/resumefinderapp/upload1">Upload Resume</a>
</form>
<%if(array != null) {%>
<% for(File file: array) { %>
<%=file.getName() %>
<a href="./downloadfile?filename=<%=file.getName()%>">Download here!!!</a>
<% } %>
<% } %>


</body>
</html>