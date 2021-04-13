<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

	<title> View Cities</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - View Cities</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- put new button: Add Country -->
			<input type="button" value="Add City" 
				   onclick="window.location.href='addCityFormOne'; return false;" 
				   class = "add-button"
			/> 
			
		
			
			<h3>Cities:</h3>
			
			<!-- add our html table here -->
			<table>
			
				<tr>
				 	<th>City Name </th>
				 	<th>Country Name </th>
				 	<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCity" items="${cities}">
					
					<!-- construct an "update" link with country id -->
					<c:url var="updateLink" value="/user/updateCityForm">
						<c:param name="cityId" value="${tempCity.cityId}" />
					</c:url>
					
					<!-- construct an "delete" link with country id -->
					<c:url var="deleteLink" value="/user/deleteCity">
						<c:param name="cityId" value="${tempCity.cityId}" />
					</c:url>
					
					<tr> 
						<td> ${tempCity.cityName} </td>
						<td> ${tempCity.country.countryName} </td>
						<td> 
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<!-- display the delete link -->
							<a href="${deleteLink}"
							   onclick="if(!(confirm('Are you sure you want to delete this City?'))) return false">Delete</a>
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