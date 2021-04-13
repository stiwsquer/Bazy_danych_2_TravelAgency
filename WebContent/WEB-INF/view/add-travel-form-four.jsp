<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title> Add Travel</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - Add Travel</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<h3>Select Hotel:</h3>
			
			
			<table>
			
				<tr>
				 	<th>Hotel Name </th>
				 	<th>Hotel Price </th>
				 	<th>Rating </th>
				 	<th>Action</th>
				</tr>
				
			
				<c:forEach var="tempHotel" items="${hotels}">
					
					
					<c:url var="selectLink" value="/user/processAddTravelFormFour">
						<c:param name="hotelId" value="${tempHotel.hotelId}" />
					</c:url>
					
					
					
					<tr> 
						<td> ${tempHotel.hotelName} </td>
						<td> ${tempHotel.hotelPrice} </td>
						<td> ${tempHotel.rating} </td>
						<td> 
							
							<a href="${selectLink}">Select</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			<div style = "clear; both;" >  </div>
			<p> 
				<a href="${pageContext.request.contextPath}/user/addTravelFormOne">Back to start</a>
			</p>
		</div>
	</div>
	
</body>
</html>