<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-news" />
<c:url var="NewURL" value="/quan-tri/bai-viet" />
<html>
<head>
<title>
<c:if test="${empty model.id}">Thêm bài viết</c:if> 
<c:if test="${not empty model.id}">Chỉnh sửa bài viết</c:if>
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
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<c:if test="${empty model.id}"><li class="active">Thêm bài viết</li></c:if> 
					<c:if test="${not empty model.id}"><li class="active">Chỉnh sửa bài viết</li></c:if>
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
									<select class="form-control" id="categoryId" name="categoryId">
										<c:if test="${empty model.categoryId}">
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.id}">${item.name}</option>
											</c:forEach>
										</c:if>
										<c:if test="${not empty model.categoryId}">
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.id}"
													<c:if test="${item.id == model.categoryId}">selected="selected"</c:if>>
													${item.name}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiêu
									đề</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"
										value="${model.title}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Hình
									đại diện</label>
								<div class="col-sm-9">
									<input type="file" class="form-control" id="thumbnail"
										name="thumbnail" accept="image/png, image/jpeg, image/jpg" />${model.thumbnail}
									<!-- accept="image/png, image/jpeg, image/jpg" -->
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô
									tả ngắn</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="shortDescription"
										name="shortDescription" value="${model.shortDescription}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Nội
									dung</label>
								<div class="col-sm-9">
									<textarea rows="" cols="" id="content" name="content"
										style="width: 820px; height: 175px">${model.content}</textarea>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật bài viết" id="btnAddOrUpdateNew" />
									</c:if>
									<c:if test="${empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Thêm bài viết" id="btnAddOrUpdateNew" />
									</c:if>
								</div>
							</div>
							<input type="hidden" value="${model.id}" id="id" name="id" />
							<input type="hidden" value="${model.thumbnail}" id="thumb" />
							<input type="hidden" value="${model.base64}" id="base64" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		/* $(document).ready(function() {
		}); */
		var editor = '';
		$(document).ready(function() {
			editor = CKEDITOR.replace('content');
		});

		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});

			data["content"] = editor.getData();
			var id = $('#id').val();
			var file = $('#thumbnail')[0].files[0];
			if (file != undefined) {
				var reader = new FileReader();
				reader.onload = function(e) {
					data["base64"] = e.target.result;
					data["thumbnail"] = file.name;
					if (id == "") {
						addNew(data);
					} else {
						updateNew(data);
					}
				};
				reader.readAsDataURL(file);

			} else {
				if (id == "") {
					data["base64"] = '';
					data["thumbnail"] = '';
					addNew(data);
				} else {
					data["base64"] = $('#base64').val();
					data["thumbnail"] = $('#thumb').val();
					updateNew(data);
				}
			}

		});

		function addNew(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${NewURL}";
					alert("Thêm thành công");
					//console.log(result);
				},
				error : function(error) {
					window.location.href = "${NewURL}";
					alert("Thêm thất bại");
					//console.log(error);
				}
			});
		}
		function updateNew(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${NewURL}";
					alert("Cập nhật thành công");
					//console.log(result);
				},
				error : function(error) {
					window.location.href = "${NewURL}";
					alert("Cập nhật thất bại");
					//console.log(error);
				}
			});
		}
	</script>
</body>
</html>
