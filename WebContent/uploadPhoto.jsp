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
<title>UploadPhoto</title>
<script language="javascript" type="text/javascript">
function validate() 
{ 
	
var extensions = new Array("jpg","jpeg","gif","png","bmp");  
var image_file = document.StrutsUploadFrm.theFile.value; 

var image_length = image_file.length;
var pos = image_file.lastIndexOf('.') + 1; 
var ext = image_file.substring(pos, image_length); 
var final_ext = ext.toLowerCase(); 
for (i = 0; i < extensions.length; i++) 
{ 
if(extensions[i] == final_ext) 
 { 
    
return true; 
   
} 
} 
alert("You must upload an image file with one of the following extensions: "+ extensions.join(', ') +"."); 
return false; 
} 
</script>
</head>
<body oncontextmenu="return false;" onselectstart="return false;" ondragout="return false;">

<%@ include file="header.jsp"%>
<div style="padding-left:160px;">
<%@ include file="sidebar.jsp"%>
<div style="float:right; padding-right:100px; padding-top:50px;">
<a href="contact.jsp"><img src="images/logo.gif" height="300" width="200" border=none></img></a></div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

<html:form action="/fileUpload" method="post" enctype="multipart/form-data" onsubmit="return validate();">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Select a Category : 
<html:select property="category">
<html:option value="">--choose any one--</html:option>
<html:option value="wildlife">--Wild Life--</html:option>
<html:option value="babies">--Babies--</html:option> 
<html:option value="nature">--Nature--</html:option> 
<html:option value="scenaries">--Scenaries--</html:option> 
<html:option value="landscapes">--Landscapes--</html:option> 
<html:option value="cars">--Cars--</html:option> 
<html:option value="bikes">--Bikes--</html:option> 
<html:option value="sports">--Sports--</html:option> 
<html:option value="food">--Food--</html:option> 
<html:option value="places">--Places--</html:option>
</html:select><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
<em>Choose a File to upload :</em>
<html:file property="theFile" /><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Cost in $ :
<html:text property="cost" size="5"></html:text><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;
<html:submit>Upload Photo</html:submit><br/>
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
${requestScope.fileuploadstatus}
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</html:form>
</div>
<%@ include file="footer.jsp"%>

</body>
</html>