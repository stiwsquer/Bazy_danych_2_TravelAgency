<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title> Select Country</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - Select Country for new City</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<h3>Select Country:</h3>
			
			<!-- add our html table here -->
			<table>
			
				<tr>
				 	<th>Country Name </th>
				 	<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCountry" items="${countries}">
					
					<!-- construct an "update" link with country id -->
					<c:url var="selectLink" value="/user/processAddCityFormTwo">
						<c:param name="countryId" value="${tempCountry.countryId}" />
					</c:url>
					
					
					
					<tr> 
						<td> ${tempCountry.countryName} </td>
					
						<td> 
							<!-- display the select link -->
							<a href="${selectLink}">Select</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			<div style = "clear; both;" >  </div>
			<p> 
				<a href="${pageContext.request.contextPath}/user/addCityFormOne">Back</a>
			</p>
		</div>
	</div>
	
</body>
</html>