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

<P> Welcome To Add Customer Page !! {customerId} </P>
<form action="addCustomer" method="POST">
            <% String custId =(String)request.getAttribute("uname");%> 
            Customer Id:<input type="text" name="custId" value="${custId}"/>
            <br>
            <% String firstName =(String)request.getAttribute("uname");%> 
            First Name :<input type="text" name="firstName" value="${firstName}"/>
            <br>
            <% String lastName =(String)request.getAttribute("uname");%> 
            Last Name  :<input type="text" name="lastName" value="${lastName}"/>
            <br>
            <% String age =(String)request.getAttribute("uname");%> 
            Age        :<input type="text" name="age" value="${age}"/>
            <br>
            <% String gender =(String)request.getAttribute("uname");%> 
            Gender     :<input type="text" name="gender" value="${gender}"/>
            <br><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>