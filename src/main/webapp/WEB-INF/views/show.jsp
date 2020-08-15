<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidates List</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
${msg }
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="hai"%>
<table border="4" cellspacing="4" cellpadding="4">
<tr><th>Regno</th><th>Name</th><th>Department</th><th>CGPA</th><th>Diploma</th><th>HSC</th>
<th>SSLC</th><th>Skills</th><th>Certifications</th><th>Career</th><th>Email</th>
<th>Mobile Number</th><th>Status</th><th>Actions</th></tr>
<hai:forEach var="yet" items="${every }">
<tr>
<td>${yet.regno }</td><td>${yet.name }</td><td>${yet.department }</td><td>${yet.cgpa }</td>
<td>${yet.diploma }</td><td>${yet.hsc }</td><td>${yet.sslc }</td><td>${yet.skills }</td>
<td>${yet.certifications }</td><td>${yet.career }</td><td>${yet.email }</td><td>${yet.mobile }</td>
<td>${yet.status }</td>
<td><ul>
<li><a href="update?reg=${yet.regno }">Update</a></li>
<li><a href="remove?reg=${yet.regno }">Delete</a></li>
</ul></td>
</tr>
</hai:forEach>
</table>
<h3><a href="report?form=pdf">Generate As PDF</a></h3>
<h3><a href="report?form=html">Generate As HTML</a></h3>
<h2><a href="home">Home</a></h2>
<h2><a href="logout">Logout</a></h2>
</body>
</html>