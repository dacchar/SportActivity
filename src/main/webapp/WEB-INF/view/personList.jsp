<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
		<title>
			<spring:message code="personlist.title"/>
		</title>  
	</head>  
	<body>  
		<center>  
			<div style="color: teal;font-size: 30px">
				<spring:message code="personlist.title"/>
			</div>
			
			<c:if test="${!empty person}">  
				<table border="1" bgcolor="black" width="600px">  
					<tr style="background-color: teal;color: white;text-align: center;" height="40px">  
						<td>
							<spring:message code="personlist.table.column.id"/>
						</td>  
						<td>
							<spring:message code="personlist.table.column.name"/>
						</td>  
					</tr>  
					
					<c:forEach items="${person}" var="person">  
						<tr style="background-color:white;color: black;text-align: center;" height="30px" >  
							<td><c:out value="${person.personId}"/></td>  
							<td><c:out value="${person.name}"/></td>
						</tr>  
					</c:forEach>  
				</table>  
			</c:if>  
		</center>
		
		<!-- 
		<a href="<c:url value="/personList/new"/>" >Add person</a>
		 -->
		  
	</body>  
</html>  