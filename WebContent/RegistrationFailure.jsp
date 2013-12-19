<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="header.jsp"%><br />
<br>
<div style="margin-left: 100px; width: 800px; position: bottom">

<center>
<h2 style="color:#0061a6">Welcome to Registration</h2>

<h4 style="color:red">Duplicate UserID please ReEnter</h4>
</center>
<br/>
<br/>

<html:form action="/register" onsubmit="return validateloginfrm(this)">
	<html:javascript formName="regfrm" />
	<table align="center">
		<tr>
			<td>Name</td>
			<td><html:text name="regfrm" property="userName" value=""></html:text></td>

		</tr>
		<tr>
			<td>User Id</td>
			<td><html:text name="regfrm" property="userId" value=""></html:text></td>

		</tr>
		
		
		<tr>
			<td>Password</td>
			<td><html:password name="regfrm" property="password" value=""></html:password></td>
		</tr>
		<tr>
			<td>Account Number&nbsp;&nbsp;</td>
			<td><html:text name="regfrm" property="accountnumber" value=""></html:text></td>
		</tr>
		
		
		
		<tr>
			<td>Gender</td>
			<td><html:radio name="regfrm" property="gender" value="male" >male</html:radio>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:radio name="regfrm" property="gender" value="female">female</html:radio></td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><html:text name="regfrm" property="email" value=""></html:text></td>
		</tr>
		
		<tr>
			<td>Contact Number&nbsp;&nbsp;</td>
			<td><html:text name="regfrm" property="mobilenumber" value=""></html:text></td>
		</tr>
		
		<tr>
			<td>Location</td>
			<td><html:text name="regfrm" property="location" value=""></html:text></td>
		</tr>
		
		
	</table>
	<br>
	<br>
	<center><html:submit>
	</html:submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:reset></html:reset></center>


</html:form> 
	</div>
	<br/>
	<br/>
<%@include file="footer.jsp"%>
</body>
</html>