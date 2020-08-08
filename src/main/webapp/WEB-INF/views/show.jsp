<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidates List</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="hai"%>
<table border="4" cellspacing="4" cellpadding="4">
<tr><th>Regno</th><th>Name</th><th>Department</th><th>CGPA</th><th>Diploma</th><th>HSC</th>
<th>SSLC</th><th>Skills</th>
<th>Certifications</th><th>Career</th><th>Email</th><th>Mobile Number</th><th>Status</th></tr>
<hai:forEach var="yet" items="${every }">
<tr>
<td>${yet.regno }</td><td>${yet.name }</td><td>${yet.department }</td><td>${yet.cgpa }</td>
<td>${yet.diploma }</td><td>${yet.hsc }</td><td>${yet.sslc }</td><td>${yet.skills }</td>
<td>${yet.certifications }</td><td>${yet.career }</td><td>${yet.email }</td><td>${yet.mobile }</td>
<td>${yet.status }</td>
</tr>
</hai:forEach>
</table>
</body>
</html>