<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${not empty categoryForName}">
	<title>${categoryForName.name}</title>
</c:if>
<c:if test="${empty categoryForName}">
	<title>Trang chủ</title>
</c:if>
</head>
<body>
	<!-- Blog Entries Column -->
	<div class="col-md-8">

		<h1 class="my-4">
			<c:if test="${not empty categoryForName}">
					${categoryForName.name}
			</c:if>
			<c:if test="${empty categoryForName}">
					Tin tức gần đây
			</c:if>
		</h1>

		<!-- Blog Post -->
		<c:forEach var="item" items="${news.listResult}">
			<div class="card mb-4">
				<img class="card-img-top" src="http://placehold.it/750x300"
					alt="Card image cap">
				<div class="card-body">
					<h2 class="card-title">${item.title}</h2>
					<p class="card-text">${item.shortDescription}</p>
					<a href="<c:url value='/bai-viet?id=${item.id}'/>" class="btn btn-primary">Read More &rarr;</a>
				</div>
				<div class="card-footer text-muted">
					Posted on ${item.createdDate} by <a href="#">Lưu Minh</a>
				</div>
			</div>
		</c:forEach>

	</div>
</body>
</html>