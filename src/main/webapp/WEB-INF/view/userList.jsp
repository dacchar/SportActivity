<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
		<title>
			<spring:message code="userlist.title"/>
		</title>  
	</head>  
	<body>  
		<center>  
			<div style="color: teal;font-size: 30px">
				<spring:message code="userlist.title"/>
			</div>
			
			<c:if test="${!empty user}">  
				<table border="1" bgcolor="black" width="600px">  
					<tr style="background-color: teal;color: white;text-align: center;" height="40px">  
						<td><spring:message code="userlist.table.column.id"/></td>  
						<td><spring:message code="userlist.table.column.name"/></td>  
						<td><spring:message code="userlist.table.column.avatar"/></td>
						<td></td>
						<td></td>
					</tr>  
					
					<c:forEach items="${user}" var="user">  
						<tr style="background-color:white;color: black;text-align: center;" height="30px" >  
							<td><c:out value="${user.userId}"/></td>  
							<td><c:out value="${user.username}"/></td>
							<td><img width="48" height="48" src="<c:url value="/data/userList/${user.userId}/getImage"/>"></img></td>
							<td><a href="<c:url value="/data/userList/${user.userId}/edit"/>">
									<img src="<c:url value="/resources/images/1395252654_edit-notes.png"/>"></img>
								</a>
							</td>
							<td><a href="<c:url value="/data/userList/${user.userId}/delete"/>">
									<img src="<c:url value="/resources/images/erase.png"/>"></img>
								</a>
							</td>
						</tr>  
					</c:forEach>  
				</table>  
			</c:if>  
		</center>
		
	</body>  
</html>  