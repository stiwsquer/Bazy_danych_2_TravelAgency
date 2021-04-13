<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title> Select Start City</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - Select Start City</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<h3>Select Start City:</h3>
			
			
			<table>
			
				<tr>
				 	<th>City Name </th>
				 	<th>Action</th>
				</tr>
				
			
				<c:forEach var="tempCity" items="${cities}">
					
					
					<c:url var="selectLink" value="/user/processAddTravelFormTwo">
						<c:param name="cityId" value="${tempCity.cityId}" />
					</c:url>
					
					
					
					<tr> 
						<td> ${tempCity.cityName} </td>
					
						<td> 
							
							<a href="${selectLink}">Select</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			<div style = "clear; both;" >  </div>
			<p> 
				<a href="${pageContext.request.contextPath}/user/addTravelFormOne">Back</a>
			</p>
		</div>
	</div>
	
</body>
</html>