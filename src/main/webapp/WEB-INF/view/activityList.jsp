<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
		<title>
			<spring:message code="activitylist.title"/>
		</title>
		
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
		  
	</head>  
	<body>  
		<center>  
			<div style="color: teal;font-size: 30px">
				<spring:message code="activitylist.title"/>
			</div>
			
			<c:if test="${!empty activityFilter}">
			
				<c:set var="method" value="put"/>
				
				<form:form method="${method}" commandName="activityFilter">
				    <table>
					    <tr>
					        <td><form:label path="dateStart"><spring:message code="activitylist.label.dateStart"/></form:label></td>
					        <td><form:input path="dateStart"/></td>
					        <td><form:errors path="dateStart" cssClass="error"></form:errors></td>
					    </tr>
					    
					    <tr>
					        <td><form:label path="dateEnd"><spring:message code="activitylist.label.dateEnd"/></form:label></td>
					        <td><form:input path="dateEnd"/></td>
					        <td><form:errors path="dateEnd" cssClass="error"></form:errors></td>
					    </tr>
					    
					    <tr>
					    	<td><form:radiobutton path="sportDeviceFiltered" value="false"/><spring:message code="activitylist.label.sportDeviceFiltered.All"/></td>
					    	<td>
							</td>
					    </tr>
					    
					    <tr>
					    	 <td><form:radiobutton path="sportDeviceFiltered" value="true"/><spring:message code="activitylist.label.sportDeviceFiltered.OnlyOne"/></td>
					    	<td>
								<select name="sportDevice">
								    <c:forEach var="currentSportDevice" items="${sportDevices}">
								        <option value="${currentSportDevice.sportDeviceId}"
								        	<c:if test='${currentSportDevice.sportDeviceId == activityFilter.sportDevice.sportDeviceId }'> 
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
					        <td>
					        </td>
					        <td>
					            <input type="submit" value="<spring:message code="common.ok"/>"/>
					        </td>
					    </tr>
					</table>					    
				</form:form>
				

				<table border="1" bgcolor="black" width="600px">  
					<tr style="background-color: teal;color: white;text-align: center;" height="40px">  
						<td><spring:message code="activitylist.table.column.id"/></td>  
						<td><spring:message code="activitylist.table.column.activitydate"/></td>
						<td></td>  
						<td><spring:message code="activitylist.table.column.amount"/></td>  
						<td><spring:message code="activitylist.table.column.name"/></td>
						<td><spring:message code="activitylist.table.column.sportDevice"/></td>
						<td></td>
						<td></td>
					</tr>  
					
					<c:forEach items="${activity}" var="activity">  
						<tr style="background-color:white;color: black;text-align: center;" height="30px" >  
							<td><c:out value="${activity.activityId}"/></td>
							<td><fmt:formatDate value="${activity.activityDate}" pattern="dd.MM.yyyy" type="date" dateStyle="long" /></td>
							<td><c:out value="${activity.activityType.name}"/></td>
							<td><c:out value="${activity.amount}"/></td>
							<td><c:out value="${activity.person.name}"/></td>  
							<td><c:out value="${activity.sportDevice.name}"/></td>
							<td><a href="<c:url value="/data/activityList/${activity.activityId}/edit"/>"><img src="/SportActivity/resources/images/1395252654_edit-notes.png" alt="" /></a></td>
							<td><a href="<c:url value="/data/activityList/${activity.activityId}/delete"/>"><img src="/SportActivity/resources/images/erase.png" alt="" /></a></td>
						</tr>  
					</c:forEach>  
				</table>  
			</c:if>  
		</center>
		
		<a href="<c:url value="/data/activityList/new"/>" > <spring:message code="activitylist.table.add"/> </a>
		  
	</body>  
</html>  