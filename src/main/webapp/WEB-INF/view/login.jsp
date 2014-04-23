<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
	<head>
		<title><spring:message code="login.title"/></title>
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	</head>
	
	<body onload='document.f.j_username.focus();'>
	 
		<c:if test="${not empty error}">
			<div class="error">
				<spring:message code="login.error.text"/>
				<spring:message code="login.error.cause" arguments="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</div>
		</c:if>
	 
	 	<!-- 
		<form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
		 -->
		<form name='f' action="<c:url value='/perform_login' />" method='POST'>
		
			<table>
				<tr>
					<td><spring:message code="login.label.user"/></td>
					<!-- 'usrname' defined in spring-security.xml -->
					<td><input type='text' name='usrname' value=''></td>
				</tr>
				<tr>
					<td><spring:message code="login.label.password"/></td>
					<!-- 'pwd' defined in spring-security.xml -->
					<td><input type='password' name='pwd' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit" value="<spring:message code="common.ok"/>" /></td>
					<td colspan='2'><input name="reset" type="<spring:message code="common.reset"/>" /></td>
				</tr>
			</table>
	 
		</form>
	</body>

</html>