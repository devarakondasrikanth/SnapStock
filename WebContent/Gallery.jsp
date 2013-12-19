<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SnapStock-A Mustor of royalty photos</title>
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
		img.style.width = '400px';
		img.style.height = '400px';

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
</script>
</head>
<body oncontextmenu="return false;" onselectstart="return false;" ondragout="return false;">

<%@include file="header.jsp"%><br />
<%@include file="sidebar.jsp"%><br />
<c:if test="${sessionScope.login.userName eq null}"><center><h3>Sign in to view your Gallery<br/></h3></center></c:if>
<c:forEach items="${requestScope.userpix}" var="photo">
<div id="imgbox"></div>
<div style="width:200px;height:200px;float:left" >
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://localhost:8080/Project/upload/${photo.category}/${photo.imgsrc}" height="100" width="156" onmouseover="Large(this)"/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cost:  ${photo.cost }
</div>
</c:forEach>
<br/><br/>
<!-- <center><center><center><center> -->
<br></br>
<br></br>
<br></br>
<%@include file="footer.jsp"%>
</body>
</html>