<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SnapStock-A Mustor of royalty photos</title>
<link href="default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function getElementLeft(elm) {
		var x = 0;
		x = elm.offsetLeft;
		elm = elm.offsetParent;
		while (elm != null) {
			x = parseInt(x) + parseInt(elm.offsetLeft);
			elm = elm.offsetParent;
		}
		return x;
	}

	function getElementTop(elm) {
		var y = 0;
		y = elm.offsetTop;
		elm = elm.offsetParent;
		while (elm != null) {
			y = parseInt(y) + parseInt(elm.offsetTop);
			elm = elm.offsetParent;
		}

		return y;
	}

	function Large(obj) {
		var imgbox = document.getElementById("imgbox");
		imgbox.style.visibility = 'visible';
		var img = document.createElement("img");
		img.src = obj.src;
		img.style.width = '300px';
		img.style.height = '300px';

		if (img.addEventListener) {
			img.addEventListener('mouseout', Out, false);
		} else {
			img.attachEvent('onmouseout', Out);
		}
		imgbox.innerHTML = '';
		imgbox.appendChild(img);
		imgbox.style.left = (getElementLeft(obj) - 250) + 'px';
		imgbox.style.top = (getElementTop(obj) - 230) + 'px';
	}

	function Out() {
		document.getElementById("imgbox").style.visibility = 'hidden';
	}
	function disableBackButton()
	{
	window.history.forward();
	}
	setTimeout("disableBackButton()", 0);
</script>
</head>
<body onselectstart="return false;" ondragstart="return false;"	oncontextmenu="return false;">


<div id="wrapper"><%@include file="header.jsp"%>
	<div id="page">
		<div id="page-bgtop">
			<div id="content">
				<div class="post">
				<h2 class="title"><a href="#">Most Downloaded Photos</a></h2>
				<p class="byline"></p>
					<c:forEach items="${requestScope.plist}" var="photo">
					<div style="width: 140px; height: 200px; float: left">
						<div id="imgbox"></div>
						<img src="http://localhost:8080/Project/upload/${photo.category}/${photo.imgsrc}" height="80" width="126" onmouseover="Large(this)"/>
						<br/>&nbsp;&nbsp;Category :${photo.category }<br/>&nbsp;&nbsp;Cost$: ${photo.cost }</div>
					</c:forEach>
					</div><br/><br/><br/><br/><br/><br/><br/>
					<div class="post">
					<p class="byline"></p>
						<div class="img">
							<h2 class="title"><a href="#">NEW ARRIVALS</a></h2>
							<p><marquee behavior="scroll" direction="left" onmouseover=	this.stop();; onmouseout=this.start();;>
							<c:forEach items="${requestScope.arrphoto}" var="photo1">
								<div style="width: 150px; height: 200px; float: left"><img src="http://localhost:8080/Project/upload/${photo1.category}/${photo1.imgsrc}" height="90" width="130" />
								<br/>&nbsp;&nbsp;Category :${photo1.category }<br/>&nbsp;&nbsp;Cost$: ${photo1.cost }</div>
							</c:forEach> </marquee></p>
						</div>
					</div>
			</div>
				<%@include file="sidebar.jsp"%> 
			<div style="clear: both; height: 1px"></div>
		</div>
	</div>
		<%@include file="footer.jsp"%>
</div>
</body>
</html>