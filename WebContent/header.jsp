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
			<h1><a href="index.jsp">SNAPSTOCK</a></h1>
			<h2><a href="#">Mustor of royalty photos</a></h2>
		</div>
		<div id="menu">
			<ul>
				<li class="active"><a href="index.jsp">Home</a></li>
				<c:if test="${sessionScope.login.userName eq null}">
				<li><a href="/Project/userpix.do">Gallery</a></li>
				</c:if>
				<c:if test="${sessionScope.login.userName ne null}">
				<li><a href="profile.jsp">Profile</a></li>
				</c:if>
				<li><a href="/Project/history.do">History</a></li>
				<li><a href="contact.jsp">Contact</a></li>
				<c:if test="${sessionScope.login.userName eq null}">
				<li><a href="login.jsp">Sign in</a></li>
				<li><a href="Registration.jsp">sign up</a></li></c:if>
				 <c:if test="${sessionScope.login.userName ne null}">
				 <li><a href="uploadPhoto.jsp">Upload</a></li>				 
				<li> <a href="/Project/logout.do">Log Out</a></li>
				
				</c:if>
			</ul>
		</div>
	</div>
	

</body>
</html>