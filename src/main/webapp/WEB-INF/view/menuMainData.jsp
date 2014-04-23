<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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