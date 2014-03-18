<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
	<title><spring:message code="login.title"/></title>
	
	<style>
		.errorblock {
			color: #ff0000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
	</style>
</head>

<body onload='document.f.j_username.focus();'>
 
	<c:if test="${not empty error}">
		<div class="errorblock">
			<spring:message code="login.error.text"/>
			<spring:message code="login.error.cause" arguments="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}" />
		</div>
	</c:if>
 
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
 
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="<spring:message code="common.ok"/>" /></td>
				<td colspan='2'><input name="reset" type="<spring:message code="common.reset"/>" /></td>
			</tr>
		</table>
 
	</form>
</body>

</html>