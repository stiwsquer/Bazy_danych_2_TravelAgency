<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>

	<title> Home Page</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - User Account</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- put new button: Add Travel -->
			<input type="button" value="Add Travel" 
				   onclick="window.location.href='addTravelFormOne'; return false;" 
				   class = "add-button"
			/> 
			
			<!-- put new button: Udate data-->
			<input type="button" value="Update Your Data" 
				   onclick="window.location.href='updateUserDataForm'; return false;" 
				   class = "add-button"
			/> 
			
			
			<!-- put new button: Log out-->
			<input type="button" value="Log out" 
				   onclick="window.location.href='logOut'; return false;" 
				   class = "add-button"
			/> 
			
			<br><br><br>
			
			<!--  add a search box -->
            <form:form action="searchForTravel" method="GET">
                Search travel: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			
		
			
			
			<h3>Your Travels:</h3>
			
			<!-- add our html table here -->
			<table>
			
				<tr>
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
					<c:url var="deleteLink" value="/user/deleteUsersTravel">
						<c:param name="travelId" value="${tempTravel.travelId}" />
					</c:url>
					
					<tr> 
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
		</div>
	</div>
	
</body>
</html>