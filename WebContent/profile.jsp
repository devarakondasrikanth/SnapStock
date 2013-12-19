<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to SnapStock</title>
</head>
<body oncontextmenu="return false;" onselectstart="return false;" ondragout="return false;">
<%@include file="header.jsp"%>
<div id="age">
<div id= "conten">
<div id="sidebar">
<a href="contact.jsp"><img src="images/logo.gif" height="300" width="200" border=none></img></a>
</div>

<div style="float: right; margin-left: 10px;">

<br/><br/><br/><font color=#0001b6 >
<table cellspacing=30 cellpadding=30 >

<tr><td>YourName</td><td>${sessionScope.login.userName }</td></tr>
<tr><td>Gender</td><td>${sessionScope.login.gender}</td></tr>
<tr><td>Mobile Number</td><td>${sessionScope.login.mobileNumber}</td></tr>
<tr><td>Email</td><td>${sessionScope.login.email }</td></tr>
<tr><td>Location</td><td>${sessionScope.login.location }</td></tr>
</table></font>
<br/>
<br/>
<center><a href="/Project/userpix.do">Click Here to Go to your Gallery</a></center>
<br/><br/><br/>
</div></div></div>
<%@include file="footer.jsp"%>
</body>

</html>