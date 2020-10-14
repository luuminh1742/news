<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-category" />
<c:url var="CategoryURL" value="/quan-tri/the-loai" />
<html>
<head>
<title>
<c:if test="${empty model.id}">Thêm thể loại</c:if> 
<c:if test="${not empty model.id}">Chỉnh sửa thể loại</c:if>
</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href="<c:url value = '/quan-tri'/>">Trang chủ</a></li>
					<c:if test="${empty model.id}">
						<li class="active">Thêm thể loại</li>
					</c:if>
					<c:if test="${not empty model.id}">
						<li class="active">Chỉnh sửa thể loại</li>
					</c:if>

				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">

						<form id="formSubmit">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thể
									loại</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="name" name="name"
										value="${model.name}" />
								</div>
							</div>
							<br /> <br />

							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật thể loại" id="btnAddOrUpdateCategory" />
									</c:if>
									<c:if test="${empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Thêm thể loại" id="btnAddOrUpdateCategory" />
									</c:if>
								</div>
							</div>
							<input type="hidden" value="${model.id}" id="id" name="id" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddOrUpdateCategory').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});

			var id = $('#id').val();
			if (id == "") {
				addCategory(data);
			} else {
				updateCategory(data);
			}

		});

		function addCategory(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${CategoryURL}";
					alert("Thêm thành công");
					//console.log(result);
				},
				error : function(error) {
					window.location.href = "${CategoryURL}";
					alert("Thêm thất bại");
					//console.log(error);
				}
			});
		}
		function updateCategory(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${CategoryURL}";
					alert("Cập nhật thành công");
					//console.log(result);
				},
				error : function(error) {
					window.location.href = "${CategoryURL}";
					alert("Cập nhật thất bại");
					//console.log(error);
				}
			});
		}
	</script>
</body>
</html>
