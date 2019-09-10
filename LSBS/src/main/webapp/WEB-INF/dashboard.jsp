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
	<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("name")==null)
{
	response.sendRedirect("admin");
}
%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">LSBS</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/booking">Booking</a></li>
				<li class="active"><a href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<c:forEach var="seats" items="${seat}">
				<div class="col-md-4"
					style="background-color: #0E6251; font-size: 30px; color: white">
					<c:set var="seat" value="${seats.seatno}" />
					<fmt:parseNumber var="j" type="number" value="${seats.seatno}" />
					<p>
						Total Seat :
						<c:out value="${j}" />
						<span></span><a href="/editseat/${seats.id}">edit</a>
					</p>
				</div>
				<div class="col-md-4"
					style="background-color: #1ABC9C; font-size: 30px; color: white">
					<c:set var="countper" value="${countper}" />
					<fmt:parseNumber var="i" type="number" value="${countper}" />
					<p>
						Available Seat :
						<c:out value="${j-i}" />
					</p>
				</div>
				<div class="col-md-4"
					style="background-color: #0E6251; font-size: 30px; color: white">
					<c:set var="countper" value="${countper}" />
					<fmt:parseNumber var="i" type="number" value="${countper}" />
					<p>
						Booked Seat :
						<c:out value="${i}" />
					</p>
				</div>
			</c:forEach>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='editseat'}">
			<form action="/updateseat" method="post">
				<input type="hidden" class="form-control" name="id"
					value="${seats.id}"> <input type="number" name="seatno"
					value="${seats.seatno}">
				<button type="submit" class="btn btn-default">Save</button>
			</form>
		</c:when>
		<c:when test="${mode=='view'}">
			<div class="container">
				<table class="table table-striped"
					style="margin-top: 50px; color: white">
					<thead style="background-color: black">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Address</th>
							<th>Payment</th>
							<th>Checkin</th>
							<th>Checkout</th>
							<th>Shift</th>
							<th>Status</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="persons" items="${person}">
							<c:forEach items="${alertDate}" var="alertdate">
								<tr
									style="${ persons.checkout<=alertdate ? 'background-color:#F5B7B1':'background-color:none'};color:black">
							</c:forEach>
							<td>${persons.id}</td>
							<td>${persons.name}</td>
							<td>${persons.email}</td>
							<td>${persons.phoneno}</td>
							<td>${persons.address}</td>
							<td>${persons.payment}</td>
							<td>${persons.checkin}</td>
							<td>${persons.checkout}</td>
							<td>${persons.shift}</td>
							<td>${persons.status}</td>
							<td><a href="/edit/${persons.id}" class="btn btn-warning"
								role="button">Edit</a></td>
							<td><a href="/delete/${persons.id}" class="btn btn-danger"
								role="button">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</c:when>
		<c:when test="${mode=='AddPerson'||mode=='EditPerson'}">
			<form action="/Add" method="Post">
				<c:if test="${mode=='EditPerson'}">
					<input type="hidden" class="form-control" name="id"
						value="${person.id}">
				</c:if>

				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" placeholder="Enter name" name="name"
						value="${person.name}">
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" placeholder="Enter email" name="email"
						value="${person.email}">
				</div>
				<div class="form-group">
					<label for="address">Address:</label> <input type="text"
						class="form-control" placeholder="Enter address" name="address"
						value="${person.address}">
				</div>
				<div class="form-group">
					<label for="phoneno">PhoneNo:</label> <input type="text"
						class="form-control" placeholder="Enter phoneno" name="phoneno"
						value="${person.phoneno}">
				</div>
				<div class="form-group">
					<label for="payment">Payment:</label> <input type="text"
						class="form-control" placeholder="Enter payment detail"
						name="payment" value="${person.payment}">
				</div>
				<div class="form-group">
					<label for="checkin">CheckIn:</label> <input type="date"
						class="form-control" placeholder="Enter checkin time"
						name="checkin" value="${person.checkin}">
				</div>
				<div class="form-group">
					<label for="checkout">CheckOut:</label> <input type="date"
						class="form-control" placeholder="Enter checkout time"
						name="checkout" value="${person.checkout}">
				</div>
				<div class="form-group">
					<label for="Shift">Shift:</label> <input type="text"
						class="form-control" placeholder="Enter Shift time" name="shift"
						value="${person.shift}">
				</div>
				<div class="form-group">
					<label for="status">Status:</label> <INPUT TYPE="Checkbox"
						Name="status" Value="active">Active <INPUT TYPE="Checkbox"
						Name="status" Value="inactive">InActive
				</div>
				<button type="submit" class="btn btn-default">Save</button>
			</form>
		</c:when>
	</c:choose>
	</div>
</body>
</html>
