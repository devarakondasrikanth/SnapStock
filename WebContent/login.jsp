<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
     <%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<title>User Login</title>
</head>
<body oncontextmenu="return false;" ondragout="return false;">

<%@include file="header.jsp"%>
<div id="age">
		<div id="age-bgtop">
			<div id="age-bgbtm">
				<div id="conten">
					<div class="post">
						<div class="entry">
						<br></br>
						<h2 class="title"><a href="#">Over 50 royalty stock photos and growing... </a></h2>
						
						<ul>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Download high-quality photos</li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Convenient, royalty-free licensing </li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Thousands of high-resolution images </li>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fast, secure and affordable </li>
						</ul>
						<br></br>
							</div>
							<div class=img>
							<img src="images/pay_logo.gif" width=830 height=140 ></img></div>
					</div></div>
								
				</div>
				</div>

				
	<c:if test="${requestScope.failure ne null}"><center><h3>Invalid UserName or Password<br/></h3></center></c:if>
	<html:form action="/login" method="post" onsubmit="return validateLoginfrm(this)">
	<html:javascript formName="loginfrm"/>
	<center>
	<h2>Log In</h2>			
	</center>
	<br/>
	<br/>
	<table align="center">
		<tr>
			<td><bean:message key="label.username" />&nbsp;&nbsp;</td>
			<td><html:text name="loginfrm" property="userinfo.userId" ></html:text></td>
		</tr>
		
		<tr>
			<td><bean:message key="label.password" />&nbsp;&nbsp;</td>
			<td><html:password name="loginfrm" property="userinfo.password" ></html:password></td>
		</tr>
	</table>
	<br>
	<br>

	<center><html:submit property="page">
		<bean:message key="button.submit" />
	</html:submit>
	</center>	
							
		</html:form>	
</div>
<%@include file="footer.jsp"%>
</body>
</html>