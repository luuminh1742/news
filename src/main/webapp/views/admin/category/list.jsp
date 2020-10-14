<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-category" />
<c:url var="CategoryURL" value="/quan-tri/the-loai" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thể loại</title>
</head>
<body>
	<div class="main-content">
		<form action="<c:url value='/quan-tri/the-loai'/>" id="formSubmit"
			method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a
							href="<c:url value='/quan-tri'/>">Trang chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm thể loại'
												href='<c:url value="/quan-tri/the-loai?type=them-the-loai"/>'>
												<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
											<button id="btnDelete" type="button"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa bài viết'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th><input type="checkbox" id="checkAll"></th>
													<th>Tên thể loại</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td><input type="checkbox" id="checkbox_${item.id}"
															value="${item.id}" class="checkAllItem"></td>
														<td>${item.name}</td>
														<td><c:url var="editURL" value="/quan-tri/the-loai">
																<c:param name="type" value="chinh-sua" />
																<c:param name="id" value="${item.id}" />
															</c:url> <a class="btn btn-sm btn-primary btn-edit"
															data-toggle="tooltip" title="Cập nhật thể loại"
															href='${editURL}'><i class="fa fa-pencil-square-o"
																aria-hidden="true"></i> </a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script>
		$(document).ready(function() {
			$('#checkAll').change(function() {
				var checkItem = $('.checkAllItem');
				if($(this).prop("checked") == true){
					for (var i = 0; i < checkItem.length; i++) {
						checkItem[i].checked = true;
					}
	            }
	            else if($(this).prop("checked") == false){
	            	for (var i = 0; i < checkItem.length; i++) {
						checkItem[i].checked = false;
					}
	            }
			});
		})
		
		
		
		
		
		$("#btnDelete").click(function() {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['ids'] = ids;
			var confirmDelete = confirm("Xác nhận xóa thể loại");
			if (confirmDelete) {
				deleteCategory(data);
			}
		});

		function deleteCategory(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				success : function(result) {
					window.location.href = "${CategoryURL}";
					alert("Xóa thành công");
				},
				error : function(error) {
					window.location.href = "${CategoryURL}";
					alert("Xóa thất bại");
				}
			});
		}
	</script>
</body>
</html>