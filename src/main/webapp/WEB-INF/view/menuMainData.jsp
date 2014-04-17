<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="menu">
	<ul>
		<li><a href="/SportActivity">Home</a></li>
		<li><a href="/SportActivity/Data">Data</a>
			<ul>
				<li><a href="/SportActivity/data/activityList?page=1">Activity list (paged)</a></li>
				<li><a href="/SportActivity/data/activityList">Activity list</a></li>
				<li><a href="/SportActivity/data/userList">Users</a></li>
			</ul>
		<li><a href="/SportActivity">About</a></li>
	</ul>
</div>