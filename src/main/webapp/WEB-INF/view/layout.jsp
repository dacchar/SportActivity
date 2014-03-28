<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<style type="text/css">
		    div {padding: 5px; margin: 0px; }
			#header-style {background: WhiteSmoke;}
			#title-style {background: #665845;}
			#subtitle-style {background: #9F8158;}
			#menu-style {background: white;}
			#primary-style {background: white;}
			#footer-style {background: Azure;}
		</style>		 

		<title>
			<tiles:insertAttribute name="title" ignore="true" />
		</title>
		
	</head>
	
	<body style="background: white;">
	
		<table border="1" cellpadding="2" cellspacing="2" >
		    <tr>
		        <td height="30" colspan="2">
		        	<div id="header-style">
		        		<tiles:insertAttribute name="header" />
		        	</div>
		        </td>
		    </tr>
		    <tr>
		        <td height="250">
		        	<div id="menu-style">
		        		<tiles:insertAttribute name="menu" />
		        	</div>
		        </td>
		        <td width="350">
		        	<div id="primary-style">
		        		<tiles:insertAttribute name="body" />
		        	</div>
		        </td>
		    </tr>
		    <tr>
		        <td height="30" colspan="2">
		        	<div id="footer-style">
		        		<tiles:insertAttribute name="footer" />
		        	</div>
		        </td>
		    </tr>
		</table>
	</body>
</html>