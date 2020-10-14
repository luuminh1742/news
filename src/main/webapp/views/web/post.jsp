<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài viết</title>
</head>
<body>
	<!-- Post Content Column -->
	<div class="col-lg-8">

		<!-- Title -->
		<h1 class="mt-4">${news.title}</h1>

		<!-- Date/Time -->
		<p>Posted on ${news.createdDate} - by <a href="#">${news.createdBy}</a></p>

		<hr>

		<div>
			${news.content}
		</div>

		<hr>

		<!-- Comments Form -->
		<div class="card my-4">
			<h5 class="card-header">Leave a Comment:</h5>
			<div class="card-body">
				<form>
					<div class="form-group">
						<textarea class="form-control" rows="3"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>

		<!-- Single Comment -->
		<div class="media mb-4">
			<img class="d-flex mr-3 rounded-circle"
				src="http://placehold.it/50x50" alt="">
			<div class="media-body">
				<h5 class="mt-0">Commenter Name</h5>
				Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
				scelerisque ante sollicitudin. Cras purus odio, vestibulum in
				vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi
				vulputate fringilla. Donec lacinia congue felis in faucibus.
			</div>
		</div>

		<!-- Comment with nested comments -->
		<div class="media mb-4">
			<img class="d-flex mr-3 rounded-circle"
				src="http://placehold.it/50x50" alt="">
			<div class="media-body">
				<h5 class="mt-0">Commenter Name</h5>
				Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
				scelerisque ante sollicitudin. Cras purus odio, vestibulum in
				vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi
				vulputate fringilla. Donec lacinia congue felis in faucibus.

				<div class="media mt-4">
					<img class="d-flex mr-3 rounded-circle"
						src="http://placehold.it/50x50" alt="">
					<div class="media-body">
						<h5 class="mt-0">Commenter Name</h5>
						Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
						scelerisque ante sollicitudin. Cras purus odio, vestibulum in
						vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
						nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
					</div>
				</div>

				<div class="media mt-4">
					<img class="d-flex mr-3 rounded-circle"
						src="http://placehold.it/50x50" alt="">
					<div class="media-body">
						<h5 class="mt-0">Commenter Name</h5>
						Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
						scelerisque ante sollicitudin. Cras purus odio, vestibulum in
						vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
						nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
					</div>
				</div>

			</div>
		</div>

	</div>
</body>
</html>