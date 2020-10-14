<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file = "/common/taglib.jsp" %>
<!-- Sidebar Widgets Column -->
<div class="col-md-4">

	<!-- Search Widget -->
	<div class="card my-4">
		<h5 class="card-header">Search</h5>
		<div class="card-body">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for...">
				<span class="input-group-append">
					<button class="btn btn-secondary" type="button">Go!</button>
				</span>
			</div>
		</div>
	</div>

	<!-- Categories Widget -->
	<div class="card my-4">
		<h5 class="card-header">Categories</h5>
		<div class="list-group">
			<c:forEach var="item" items="${category.listResult}">
				<a href="<c:url value='/the-loai?categoryid=${item.id}&code=${item.code}&page=1'/>" class="list-group-item">${item.name}</a>
			</c:forEach>
			
		</div>
	</div>

	<!-- Side Widget -->
	<div class="card my-4">
		<h5 class="card-header">Side Widget</h5>
		<div class="card-body">You can put anything you want inside of
			these side widgets. They are easy to use, and feature the new
			Bootstrap 4 card containers!</div>
	</div>

</div>