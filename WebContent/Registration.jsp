<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>

<%@include file="header.jsp"%><br />
<br>
<div>
<div style="float:left; margin-left: 50px; width: 800px; position: bottom">

<center>
<h2 style="color:#0061a6">Welcome to Registration</h2>
</center>
<center><h3>${requestScope.error}</h3></center>


<br/>
<br/>

<html:form action="/register" onsubmit="return validateRegfrm(this)">
	<html:javascript formName="regfrm" />
	<table align="center">
		<tr>
			<td><bean:message key="label1.username" />&nbsp;&nbsp;</td>
			<td><html:text name="regfrm" property="userName" value=""></html:text></td>

		</tr>
		<tr>
			<td><bean:message key="label.userid" />&nbsp;&nbsp;</td>
			<td><html:text name="regfrm" property="userId" value=""></html:text></td>

		</tr>
		
		
		
		<tr>
			<td><bean:message key="label.password" />&nbsp;&nbsp;</td>
			<td><html:password name="regfrm" property="password" value=""></html:password></td>
		</tr>
		
		<tr>
			<td><bean:message key="label.accno" />&nbsp;&nbsp;;</td>
			<td><html:text name="regfrm" property="accountnumber" value=""></html:text></td>
		</tr>
		
		
		
		<tr>
			<td><bean:message key="label.gender" />&nbsp;&nbsp;</td>
			<td><html:radio name="regfrm" property="gender" value="male" >male</html:radio>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:radio name="regfrm" property="gender" value="female">female</html:radio></td>
		</tr>
		<tr>
			<td><bean:message key="label.email" />&nbsp;&nbsp;</td>
			<td><html:text name="regfrm" property="email" value=""></html:text></td>
		</tr>
		
		<tr>
			<td><bean:message key="label.mobno" />&nbsp;&nbsp;</td>
			<td><html:text name="regfrm" property="mobilenumber" value=""></html:text></td>
		</tr>
		
		<tr>
			<td><bean:message key="label.loc" />&nbsp;&nbsp;</td>
			<td><html:text name="regfrm" property="location" value=""></html:text></td>
		</tr>
		
		
	</table>
	<br>
	<br>
	<center><html:submit>
	</html:submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:reset></html:reset></center>
</html:form>
<br/><br/> 
	
	</div></div>
	<br/>
	<br/><br/><br/>
<%@include file="footer.jsp"%>
</body>
</html>