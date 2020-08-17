<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home of Campus</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<h1 style="color:blue">Campus Home</h1>
<h2><a href="add">Enroll New Candidate</a></h2>
<h2><a href="find">Find Candidates</a></h2>
<h2><a href="list">Listing Candidates</a></h2>
<h2><a href="logout">Logout</a></h2>
</body>
</html>