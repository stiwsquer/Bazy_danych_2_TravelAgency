<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title> View Hotels</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - View Hotels</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- put new button: Add Country -->
			<input type="button" value="Add Hotel" 
				   onclick="window.location.href='addHotelFormOne'; return false;" 
				   class = "add-button"
			/> 
			
		
			
			<h3>Hotels:</h3>
			
			<!-- add our html table here -->
			<table>
			
				<tr>
				 	<th>Hotel Name</th>
				 	<th>Hotel Price</th>
				 	<th>Rating</th>
				 	<th>City</th>
				 	<th>Company</th>
				 	<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempHotel" items="${hotels}">
					
					<!-- construct an "update" link with country id -->
					<c:url var="updateLink" value="/user/updateHotelForm">
						<c:param name="hotelId" value="${tempHotel.hotelId}" />
					</c:url>
					
					<!-- construct an "delete" link with country id -->
					<c:url var="deleteLink" value="/user/deleteHotel">
						<c:param name="hotelId" value="${tempHotel.hotelId}" />
					</c:url>
					
					<tr> 
						<td> ${tempHotel.hotelName} </td>
						<td> ${tempHotel.hotelPrice} </td>
						<td> ${tempHotel.rating} </td>
						<td> ${tempHotel.city.cityName} </td>
						<td> ${tempHotel.company.fullName} </td>
						<td> 
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<!-- display the delete link -->
							<a href="${deleteLink}"
							   onclick="if(!(confirm('Are you sure you want to delete this Country?'))) return false">Delete</a>
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