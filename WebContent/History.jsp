<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User History</title>
</head>
<body oncontextmenu="return false;" onselectstart="return false;" ondragout="return false;">
<div id="wrapper">
<%@include file="header.jsp"%>
<div id="page">
<div id="page-bgtop">
<div id="sidebar">
<a href="contact.jsp"><img src="images/logo.gif" height="300" width="200" border=none></img></a>
</div>
<div class="post">
<div id="content">

<h2 class="title"><a href="#">History</a></h2>
<p class=""></p>
<c:if test="${sessionScope.login.userName eq null}"><center><h3>Sign in to view your History<br/></h3></center>	</c:if>
<c:if test="${sessionScope.login.userName ne null}">
<div style="width: 330px;">
<hr size="2" style="color:#0061a6;" />
<div>
<table bordercolor="black" cellpadding="60" cellspacing="5">
<tr>
<td>Inv.ID</td><td>DateOfPurchase</td><td>TransID</td><td>photoId</td><td>Cost</td><td>Category</td>
</tr>
<c:forEach items="${requestScope.userhistory}" var="history">	
	<c:forEach items="${history.photoTx}" var="tx">	
	
			<tr><td><font size=3 color=#0061a6 ></font>${history.invoiceId}&nbsp;&nbsp;</td><td>${history.dateOfPurchase}</td>
			<td>${tx.transactionId}</td><td>${tx.photoInfo.photoId }</td><td>${tx.photoInfo.cost }</td><td>${tx.photoInfo.category }</td>	
			</tr>
	</c:forEach>
</c:forEach>
</table>
</div>

<hr size="2" style="color: #0061a6;" />


</div>
</c:if>

	
<div style="clear: both; height: 1px"></div>
</div>
</div>
</div>
</div>
</div>

<%@include file="footer.jsp"%>

</body>

</html>