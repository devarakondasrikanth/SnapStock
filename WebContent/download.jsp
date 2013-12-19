<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enjoy the Free Downloads</title>
</head>
<body onselectstart="return false;" ondragstart="return false;"	oncontextmenu="return false;">

<%@include file="header.jsp"%>
<div id="age">
	<div id= "conten">
		<div class=post><br/><br/><br/>
		<center><h2 class="title">Thanks For Buying</h2></center>
			<div class="entry"><br/>
			<p>Please Click on the following Link(s) to Download the Photos</p>
			<c:forEach items="${sessionScope.downlist}" var="photos">
				<div style="font-size:16px;"></div>
				<a href="/Project/photodown?pid=${photos.photoId }">Photo ID-${photos.photoId }</a><br/><br></br>
			</c:forEach>
			</div>
		</div>
	</div>
		<div align="left" id="logbar">
			<a href="contact.jsp"><img src="images/logo.gif" height=300 border="none"></img></a><br></br><br></br>
			<div style="font-size:16px; font-color:#778899;">
				
			</div>
		</div>
		<%@ include file="footer.jsp" %>	
</div>

</body>
</html>