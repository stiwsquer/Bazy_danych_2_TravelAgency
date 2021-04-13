<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>

	<title> View Travels</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - View Travels</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<h3>Travels:</h3>
			
			<!-- add our html table here -->
			<table>
			
				<tr>
					<th>User Last Name</th>
				 	<th>Travel Name </th>
				 	<th>Hotel Name </th>
				 	<th>Transport Name</th>
				 	<th>Start Date</th>
				 	<th>End Date</th>
				 	<th>Number of Persons</th>
				 	<th>Food Price</th>
				 	<th>Whole Price</th>
				 	<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempTravel" items="${travels}">
					
					<!-- construct an "delete" link with travel id -->
					<c:url var="deleteLink" value="/user/deleteTravel">
						<c:param name="travelId" value="${tempTravel.travelId}" />
					</c:url>
					
					<tr> 
						<td> ${tempTravel.user.lastName} </td>
						<td> ${tempTravel.travelName} </td>
						<td> ${tempTravel.getHotel().hotelName}  </td>
						<td> ${tempTravel.getTransport().getTransportType().transportTypeName}  </td>
						<td> ${tempTravel.dateFrom}   </td>
						<td> ${tempTravel.dateTill}  </td>
						<td> ${tempTravel.numberOfPersons} </td>
						<td> ${tempTravel.food}</td>
						<td> ${tempTravel.calculateWholeTravelPrice()}</td>
						<td> 
							<!-- display the delete link -->
							<a href="${deleteLink}"
							   onclick="if(!(confirm('Are you sure you want to delete this travel?'))) return false">Delete</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			<div style = "clear; both;" >  </div>
			<p> 
				<a href="${pageContext.request.contextPath}/user/employeeHomePage">Back to home page</a>
			</p>
		</div>
	</div>
	
</body>
</html>