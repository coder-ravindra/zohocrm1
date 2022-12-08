<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Bill</title>
</head>
<body>
<h2>Bill|Create</h2>
<hr>
<form action="genratebill" method="post">
<pre>
First Name <input type="text" name="firstName" value="${Contact.firstName}"/>
Last Name <input type="text" name="lastName" value="${Contact.lastName}"/>
Email     <input type="text" name="email" value="${Contact.email}"/>
Mobile    <input type="text" name="mobile" value="${Contact.mobile}"/>
Product   <input type="text" name="product"/>
Amount    <input type="text" name="amount"/>

<input type="submit" value="genratebill"/>

</pre>

</form>


</body>
</html>