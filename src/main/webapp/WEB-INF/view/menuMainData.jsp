<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

					<div style="text-align: left">
			        <img src="<c:url value="/resources/images/1600444-mountain-biker-in-der-silhouette-sonnenaufgang.jpg"/>" width="168" height="161"></img>
				</div>
	


<div id="menu">
	<ul>
		<li><a href="/SportActivity"><spring:message code="menu.label.home"/></a></li>
		<li><a href="/SportActivity/Data"><spring:message code="menu.label.data"/></a>
			<ul>
				<li><a href="/SportActivity/data/activityList?page=1"><spring:message code="menu.label.activityListPaged"/></a></li>
				<li><a href="/SportActivity/data/activityList"><spring:message code="menu.label.activityList"/></a></li>
				<li><a href="/SportActivity/data/userList"><spring:message code="menu.label.users"/></a></li>
			</ul>
		<li><a href="/SportActivity"><spring:message code="menu.label.about"/></a></li>
	</ul>
</div>