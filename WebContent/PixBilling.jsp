<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SnapStock-A Mustor of royalty photos</title>
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">

<%@include file="header.jsp"%>
<div>
<div style="float:left; width:350px; ">
<img src="images/logo.gif" height=330 height=300></img>
</div>
<div style="float:justify;">
					<h2>Billing Details</h2>
					<br/><br/>
					         <table class=post>
					        <tr><td><h3><font color=#0061a6>Bill Id</font></h3></td><td><h4><font color=#0061a6>${requestScope.inId}</font></h4></td></tr>
					          <tr><td><h3><font color=#0061a6>User Name</font></h3></td><td><h4><font color=#0061a6>${sessionScope.login.userName}</font></h4></td></tr>
					           <tr><td><h3><font color=#0061a6>No of photos</font></h3></td><td><h4><font color=#0061a6>${requestScope.nophotos}</font></h4></td></tr>
					            <tr><td><h3><font color=#0061a6>Account number</font></h3></td><td><h4><font color=#0061a6>${sessionScope.login.accountNumber}</font></h4></td></tr>
					         </table>
					         <br/>
					         <h2 style="color:#0061a6">Amount  ${requestScope.amt}</h2>
					         <br/>
					           <hr size="2" style="color:#0061a6"/>
					           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form method=post action="/Project/CheckBalance.do">
	<input type=submit value="click to pay" name=submit></input></form>
</div>
					    <br/>
					    <br/>
<div style="width:300px;"><center></center></div>
</div>
				</div>
				<div class="post">
					<h2 class="title"><a href="#"></a></h2>
					<p class="byline"></p>
					<div class="img">
						<p>
						<a href ="#"><img src="images/pay_logo.gif" ></a>
						</p>
						
					</div>
										
				</div>
			<div style="clear: both; height: 1px"></div>
		
	
	<!-- <form method=post action="mydirectPayment.jsp"> -->
	
	<%@include file="footer.jsp"%>
</div>
</body>
</html>