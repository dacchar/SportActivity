<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  
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
							<td width="600" colspan="2" align="center">
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
								</table>
							</td>
						</tr>

						<tr>
							<td>
								<table>
								    <tr>
								    	<td align="left"><form:radiobutton path="sportDeviceFiltered" value="false"/><spring:message code="activitylist.label.sportDeviceFiltered.All"/></td>
								    	<td>
										</td>
								    </tr>
								    
								    <tr>
								    	<td align="left"><form:radiobutton path="sportDeviceFiltered" value="true"/><spring:message code="activitylist.label.sportDeviceFiltered.OnlyOne"/></td>
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
								</table>
							</td>
							
							<td>
								<table>
								    <tr>
								    	<td align="left"><form:radiobutton path="userFiltered" value="false"/><spring:message code="activitylist.label.userFiltered.All"/></td>
								    	<td>
										</td>
								    </tr>
								    
								    <tr>
								    	<td align="left"><form:radiobutton path="userFiltered" value="true"/><spring:message code="activitylist.label.userFiltered.OnlyOne"/></td>
								    	<td align="right">
											<select name="user">
											    <c:forEach var="currentUser" items="${users}">
											        <option value="${currentUser.userId}"
											        	<c:if test='${currentUser.userId == activityFilter.user.userId }'> 
											        		selected 
											        	</c:if>    
											        >
											        	${currentUser.username}
											        </option>
											    </c:forEach>
											</select>
										</td>
								    </tr>
								</table>
							</td>
						</tr>
						
						<tr>
							<td>Sum: <c:out value="${count}"/></td>
							<td align="right">
								<input type="submit" value="<spring:message code="activitylist.label.filter"/>"/>
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
						<td><spring:message code="activitylist.table.column.avatar"/></td>
						<td><spring:message code="activitylist.table.column.sportDevice"/></td>
						<td></td>
						<td></td>
					</tr>  
				
					<c:forEach items="${pagedListHolder.pageList}" var="activity">
						<tr style="background-color:white;color: black;text-align: center;" height="30px" >  
							<td><c:out value="${activity.activityId}"/></td>
							<td><fmt:formatDate value="${activity.activityDate}" pattern="dd.MM.yyyy" type="date" dateStyle="long" /></td>
							<td><c:out value="${activity.activityType.name}"/></td>
							<td><c:out value="${activity.amount}"/></td>
							<td><c:out value="${activity.user.username}"/></td>
							<td><img width="40" height="40" src="<c:url value="/data/userList/${activity.user.userId}/getImage"/>"></img></td>
							<td><c:out value="${activity.sportDevice.name}"/></td>
							<td><a href="<c:url value="/data/activityList/${activity.activityId}/edit"/>"><img src="<c:url value="/resources/images/1395252654_edit-notes.png"/>"></img></a></td>
							<td><a href="<c:url value="/data/activityList/${activity.activityId}/delete"/>"><img src="<c:url value="/resources/images/erase.png"/>"></img></a>
							</td>
						</tr>  
					</c:forEach>
				</table>
				
				<!-- table scroll controls: -->
				<table>
					<tr>
						<td align="left">
							<c:if test="${!pagedListHolder.firstPage}">
								<a href="<c:url value="/data/activityList?page=1"/>"><spring:message code="activitylist.label.first"/></a>
								<a href="<c:url value="/data/activityList?page=${pagedListHolder.page}"/>"><spring:message code="activitylist.label.prev"/></a>
							</c:if>
						</td>
						<td align="center">
								<c:out value="${pagedListHolder.page + 1}"/> <c:out value=" of "/> <c:out value="${pagedListHolder.pageCount}"/>
						</td>
							<td align="right">
								<c:if test="${!pagedListHolder.lastPage}">
									<a href="<c:url value="/data/activityList?page=${pagedListHolder.page + 2}"/>"><spring:message code="activitylist.label.next"/></a>
									<a href="<c:url value="/data/activityList?page=${pagedListHolder.pageCount}"/>"><spring:message code="activitylist.label.last"/></a>
								</c:if>
						</td>
					</tr>
				</table>
			</c:if>  
		</center>
		
		<a href="<c:url value="/data/activityList/new"/>" > <img src="<c:url value="/resources/images/add.png"/>"></img> </a>
		<!-- <spring:message code="activitylist.table.add"/> -->
		  
	</body>  
</html>  