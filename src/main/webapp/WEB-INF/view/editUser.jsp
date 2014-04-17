<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>
			<c:out value="${title}"/>
		</title>

		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	</head>
	
	<body>
		<h2>
			<c:choose>
			    <c:when test="${user.userId == 0}">
			       <c:set var="method" value="post"/>
			       <spring:message code="userEdit.label.title.add"/>
			    </c:when>
			    <c:otherwise>
			        <c:set var="method" value="put"/>
			        <spring:message code="userEdit.label.title.edit"/>
			    </c:otherwise>
			</c:choose>
		</h2>
		
		<form:form method="${method}" commandName="user" multipart="true" enctype="multipart/form-data">
		 
		 	<!-- 
		 	<form:hidden path="userId" />
		 	 -->
		 	
		    <table>
			    <tr>
			        <td><form:label path="userId"><spring:message code="userEdit.label.id"/></form:label></td>
			        <td><form:input path="userId" disabled="false" /></td>
			        <td><form:errors path="userId" cssClass="error"></form:errors></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="username"><spring:message code="userEdit.label.username"/></form:label></td>
			        <td><form:input path="username"/></td>
			        <td><form:errors path="username" cssClass="error"></form:errors></td>
			    </tr>

			    <tr>
			    	<td></td>
			    	<td><img width="128" height="128" src="<c:url value="/data/userList/${user.userId}/getImage"/>"></img></td>
			    	<td></td>
			    </tr>

			    <tr>
			        <td><form:label path="avatar"><spring:message code="userEdit.label.avatar"/></form:label></td>
			        <td><input type="file" name="file" id="file"></input></td>
			        <td><form:errors path="avatar" cssClass="error"></form:errors></td>
			    </tr>
			    
			    <tr>
			        <td>
			            <input type="submit" value="<spring:message code="common.ok"/>"/>
			        </td>
			        <td>
			            <a href="<c:url value="/data/userList"/>"><spring:message code="common.back"/></a>
			        </td>
			    </tr>
			</table> 
		</form:form>
	</body>
</html>