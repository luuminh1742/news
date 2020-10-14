<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>
<!-- Bootstrap core CSS -->
<link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value='/template/web/css/blog-home.css'/>" rel="stylesheet">

<!-- css phân trang trang -->
<script src="<c:url value='/template/web/vendor/jquery/jquery.min.js' />"></script>
<script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
<script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->

	<div class="container">
		<div class="row">
			<dec:body />
			<!-- sidebar -->
			<%@ include file="/common/web/sidebar.jsp"%>
			<!-- sidebar -->
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->

	<%-- <script src="<c:url value='/template/web/vendor/jquery/jquery.min.js' />"></script> --%>
	<%-- <script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script> --%>

</body>
</html>