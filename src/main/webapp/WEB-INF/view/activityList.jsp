<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
		<title>
			<spring:message code="activitylist.title"/>
		</title>  
	</head>  
	<body>  
		<center>  
			<div style="color: teal;font-size: 30px">
				<spring:message code="activitylist.title"/>
			</div>
			
			<c:if test="${!empty activity}">  
				<table border="1" bgcolor="black" width="600px">  
					<tr style="background-color: teal;color: white;text-align: center;" height="40px">  
						<td>
							<spring:message code="activitylist.table.column.id"/>
						</td>  
						<td>
							<spring:message code="activitylist.table.column.activitydate"/>
						</td>  
						<td>
							<spring:message code="activitylist.table.column.amount"/>
						</td>  
						<td></td>
						<td></td>
					</tr>  
					
					<c:forEach items="${activity}" var="activity">  
						<tr style="background-color:white;color: black;text-align: center;" height="30px" >  
							<td><c:out value="${activity.idActivity}"/></td>  
							<td><c:out value="${activity.activityDate}"/></td>
							<td><c:out value="${activity.amount}"/></td>  
							<td><a href="<c:url value="/activityList/${activity.idActivity}/edit"/>">Edit</a></td>  
							<td><a href="<c:url value="/activityList/${activity.idActivity}/delete"/>">Delete</a></td>
						</tr>  
					</c:forEach>  
				</table>  
			</c:if>  
		</center>
		
		<a href="<c:url value="/activityList/new"/>" >Add activity</a>
		  
	</body>  
</html>  