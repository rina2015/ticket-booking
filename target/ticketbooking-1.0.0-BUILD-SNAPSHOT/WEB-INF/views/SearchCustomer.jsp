<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body bgcolor="pink">
<h1>
	Add Customer Page
</h1>

<P> Welcome To Search Customer Page !! </P>

<form action="searchCustomer" method="GET">
            <% String custId =(String)request.getAttribute("uname");%> 
            Customer Id:<input type="text" name="custId" value="${custId}"/>
            <br><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>