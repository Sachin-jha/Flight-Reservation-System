<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-5">
			<div class="container-sm" style="max-width: 500px">
				<h4>Flight Details...</h4>
				<table class="table table-hover">

					<tbody>
						<tr>
							<td>Flight Number:-</td>
							<td>${reservation.flight.flightNumber}</td>
						</tr>
						<tr>
							<td>Operating Airline:-</td>
							<td>${reservation.flight.operatingAirlines}</td>
						</tr>
						<tr>
							<td>Departure City:-</td>
							<td>${reservation.flight.departureCity}</td>
						</tr>
						<tr>
							<td>Arrival City:-</td>
							<td>${reservation.flight.arrivalCity}</td>
						</tr>
						<tr>
							<td>Estimated Departure Time:-</td>
							<td>${reservation.flight.estimatedDepartureTime}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="col-sm-5">
			<div class="container-sm" style="max-width: 400px">
				<h4>Passenger Details...</h4>
				<table class="table table-hover">

					<tbody>
						<tr>
							<td>First Name:-</td>
							<td>${reservation.passenger.firstName}</td>
						</tr>
						<tr>
							<td>Last Name:-</td>
							<td>${reservation.passenger.lastName}</td>
						</tr>
						<tr>
							<td>Middle Name:-</td>
							<td>${reservation.passenger.middleName}</td>
						</tr>
						<tr>
							<td>Email:-</td>
							<td>${reservation.passenger.email}</td>
						</tr>
						<tr>
							<td>Phone:-</td>
							<td>${reservation.passenger.phone}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<br>
	<div class="container">
		<h5>Click to enter Number of bags to Check-In</h5>
		<!-- Button to Open the Modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">Bags</button>

		<!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Enter Number Of Bags</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">

						<form action="completeReservation" method="post">
							<div class="form-gorup">
								<input type="text" class="form-control" placeholder="Number Of Bags" required="required" name="bagsCheckIn" />
							</div>
							<input type="hidden" value="${reservation.id}" name="reservationId" /> <br> 
								<input type="submit" class="btn btn-primary" value="Submit" />
						</form>
					</div>

				</div>
			</div>
		</div>

	</div>


</body>
</html>