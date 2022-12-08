<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>All Lead</h2>
<table>
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Mobile</th>
<th>Source</th>
<th>Billing</th>


</tr>
<c:forEach var="Contact" items="${Contacts}">
<tr>

<td><a href="ContactInfo?id=${Contact.id}">${Contact.firstName}</a></td>
<td>${Contact.lastName}</td>
 <td>${Contact.email}</td>
 <td>${Contact.mobile}</td>
 <td>${Contact.source}</td>
 <th><a href="billingForm?contactid=${Contact.id}">Billing</a></th>

 </tr>

</c:forEach>
</table>


</body>
</html>