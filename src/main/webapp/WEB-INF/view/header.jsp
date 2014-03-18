<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="right">
<table>
  <tr>
    <td>
    	Username : ${username}
    </td>
  </tr>
  <tr>
    <td>
		<c:choose>
		    <c:when test="${empty (username)}">
		        <a href="<c:url value="/j_spring_security_logout" />" > Login</a>
		    </c:when>
		    <c:otherwise>
		        <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
		    </c:otherwise>
		</c:choose>
    </td>
  </tr>
</table>
</div >

<h1><spring:message code="label.title"/></h1>

<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=de">de</a>
</span>

<span style="float: left">
    <a href="?theme=default">def</a>
    |
    <a href="?theme=black">blk</a>
    |
    <a href="?theme=blue">blu</a>
</span>

