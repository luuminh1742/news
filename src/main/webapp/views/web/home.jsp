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

		<form action="<c:url value='/trang-chu'/>" id="formSubmit"
			method="GET">

			<h1 class="my-4">
				<c:if test="${not empty categoryForName}">
                            ${categoryForName.name}
                        </c:if>
				<c:if test="${empty categoryForName}">
                            Tin tức gần đây
                        </c:if>
			</h1>

			<!-- Blog Post -->
			<c:forEach var="item" items="${model.listResult}">
				<div class="card mb-4">
					<img
						class="card-img-top item-image-thumb w-25 p-3 h-25 d-inline-block"
						src="${item.base64}" alt="Card image cap">
					<div class="card-body">
						<h2 class="card-title">${item.title}</h2>
						<p class="card-text">${item.shortDescription}</p>
						<a href="<c:url value='/bai-viet?id=${item.id}'/>"
							class="btn btn-primary">Chi tiết &rarr;</a>
					</div>
					<div class="card-footer text-muted">
						Posted on ${item.createdDate} by <a href="#">${item.createdBy}</a>
					</div>
				</div>
			</c:forEach>

			<br> <br>
			
			<ul class="pagination" id="pagination"></ul>
			<input type="hidden" value="" id="page" name="page"> 
		</form>
	</div>
	<script>
	
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 5,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});	
	</script>
</body>

</html>