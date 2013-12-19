<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Snap Stock</title>
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id=welcom>
	<c:if test="${sessionScope.login.userName eq null}">WELCOME GUEST</c:if>
<c:if test="${sessionScope.login.userName ne null}">WELCOME ${sessionScope.login.userName}</c:if>
</div>
	<div id="header">
		<div id="logo">
			<h1><a href="Welcome.jsp">SNAPSTOCK</a></h1>
			<h2><a href="#">Mustor of royalty photos</a></h2>
		</div>
		<div id="menu">
			<ul>
				<li class="active"><a href="Welcome.jsp">Home</a></li>
				<li><a href="#">Gallery</a></li>
				<li><a href="#">Uploads</a></li>
				<li><a href="contact.jsp">Contact</a></li>
				<c:if test="${sessionScope.login.userName eq null}">
				<li><a href="#">Sign in</a></li>
				</c:if>
				
				 
				
			</ul>
		</div>
	</div>
	

</body>
</html>