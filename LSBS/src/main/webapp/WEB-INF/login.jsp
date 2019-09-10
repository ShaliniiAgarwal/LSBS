<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<!--  <form action="login" method="post">
        <input type="text" name="name">
         <input type="password" name="password">
         <input type="submit" value="login">
</form>
        -->
	<div class="container text-center">

		<hr>
		<form class="form-horizontal" method="POST" action="login">
			<c:if test="${not empty error }">
				<div class="alert alert-danger">
					<c:out value="${error}"></c:out>
				</div>
			</c:if>
			<div class="form-group">
				<label class="control-label col-md-3">Username</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Password</label>
				<div class="col-md-7">
					<input type="password" class="form-control" name="password" />
				</div>
			</div>
			<div class="form-group ">
				<input type="submit" class="btn btn-primary" value="Login" />
			</div>

		</form>
	</div>



</body>
</html>
