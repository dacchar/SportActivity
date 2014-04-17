<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div style="text-align: right">
		Username : ${username}
	</div>

	<div style="text-align: right">
		<c:choose>
		    <c:when test="${empty (username)}">
		    </c:when>
		    <c:otherwise>
		        <img src="/SportActivity/data/userList/100/getImage" width="48" height="48"/>
		    </c:otherwise>
		</c:choose>	
	</div>

	
	<div style="text-align: right">
		<c:choose>
		    <c:when test="${empty (username)}">
		        <a href="<c:url value="/login" />" >Login</a>
		    </c:when>
		    <c:otherwise>
		        <a href="<c:url value="/logout" />" >Logout</a>
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
