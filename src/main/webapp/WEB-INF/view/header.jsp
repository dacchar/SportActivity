<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div style="text-align: right">
		Username : ${username}
	</div>
	
	<div style="text-align: right">
		<c:choose>
		    <c:when test="${empty (username)}">
		        <a href="<c:url value="/j_spring_security_logout" />" > Login</a>
		    </c:when>
		    <c:otherwise>
		        <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
		    </c:otherwise>
		</c:choose>	
	</div>		

	<h1><spring:message code="label.title"/></h1>
	
	<div style="text-align: right; background: WhiteSmoke;" >
	    <a href="?lang=en">en</a>
	    |
	    <a href="?lang=de">de</a>
	</div>
	
	<div style="text-align: left; background: WhiteSmoke;">
	    <a href="?theme=default">def</a>
	    |
	    <a href="?theme=black">blk</a>
	    |
	    <a href="?theme=blue">blu</a>
	</div>
