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
			    <c:when test="${activity.activityId == 0}">
			       <c:set var="method" value="post"/>
			       <spring:message code="activityEdit.label.title.add"/>
			    </c:when>
			    <c:otherwise>
			        <c:set var="method" value="put"/>
			        <spring:message code="activityEdit.label.title.edit"/>
			    </c:otherwise>
			</c:choose>
			
			
			
		</h2>
		
		<form:form method="${method}" commandName="activity">
		 
		 	<!-- 
		 	<form:hidden path="activityId" />
		 	 -->
		 	
		    <table>
			    <tr>
			        <td><form:label path="activityId"><spring:message code="activityEdit.label.id"/></form:label></td>
			        <td><form:input path="activityId" disabled="true" /></td>
			        <td><form:errors path="activityId" cssClass="error"></form:errors></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="activityDate"><spring:message code="activityEdit.label.activityDate"/></form:label></td>
			        <td><form:input path="activityDate" type="date"/></td>
			        <td><form:errors path="activityDate" cssClass="error"></form:errors></td>
			    </tr>

			    <tr>
			        <td><form:label path="activityTime"><spring:message code="activityEdit.label.activityTime"/></form:label></td>
			        <td><form:input path="activityTime" type="time"/></td>
			        <td><form:errors path="activityTime" cssClass="error"></form:errors></td>
			    </tr>

			    <tr>
			        <td><form:label path="amount"><spring:message code="activityEdit.label.amount"/></form:label></td>
			        <td><form:input path="amount" /></td>
			        <td><form:errors path="amount" cssClass="error"></form:errors></td>
			    </tr>
			    
			    <tr>
			    	<td><form:label path="activityType"><spring:message code="activityEdit.label.activityType"/></form:label></td>
			    		
			    	<td>
						<select name="activityType">
						    <c:forEach var="currentActivityType" items="${activityTypes}">
						        <option value="${currentActivityType.activityTypeId}"
						        	<c:if test='${currentActivityType.activityTypeId == activity.activityType.activityTypeId }'> 
						        		selected 
						        	</c:if>    
						        >
						        	${currentActivityType.name}
						        </option>
						    </c:forEach>
						</select>
					</td>
			    </tr>

			    <tr>
			    	<td><form:label path="user"><spring:message code="activityEdit.label.user"/></form:label></td>
			    		
			    	<td>
						<select name="user">
						    <c:forEach var="currentUser" items="${users}">
						        <option value="${currentUser.userId}"
						        	<c:if test='${currentUser.userId == activity.user.userId }'> 
						        		selected 
						        	</c:if>    
						        >
						        	${currentUser.username}
						        </option>
						    </c:forEach>
						</select>
					</td>
			    </tr>
			    	
			    <tr>
			    	<td><form:label path="sportDevice"><spring:message code="activityEdit.label.sportDevice"/></form:label></td>
			    		
			    	<td>
						<select name="sportDevice">
						    <c:forEach var="currentSportDevice" items="${sportDevices}">
						        <option value="${currentSportDevice.sportDeviceId}"
						        	<c:if test='${currentSportDevice.sportDeviceId == activity.sportDevice.sportDeviceId }'> 
						        		selected 
						        	</c:if>    
						        >
						        	${currentSportDevice.name}
						        </option>
						    </c:forEach>
						</select>
					</td>
			    </tr>
			    	
			    <tr>
			        <td><form:label path="comments"><spring:message code="activityEdit.label.comments"/></form:label></td>
			        <td><form:input path="comments" size="64" maxlength="256"/></td>
			        <td><form:errors path="comments" cssClass="error"></form:errors></td>
			    </tr>
			    
			    <tr>
			        <td>
			            <input type="submit" value="<spring:message code="common.ok"/>"/>
			        </td>
			        <td>
			            <a href="<c:url value="/data/activityList?page=1"/>"><spring:message code="common.back"/></a>
			        </td>
			    </tr>
			</table> 
		</form:form>
	</body>
</html>