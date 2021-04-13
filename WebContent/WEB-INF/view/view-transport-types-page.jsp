<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title> View Transport Types</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - View Transport Types</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- put new button: Add Country -->
			<input type="button" value="Add Transport" 
				   onclick="window.location.href='addTransportTypeForm'; return false;" 
				   class = "add-button"
			/> 
			
		
			
			<h3>Transport Types:</h3>
			
			<!-- add our html table here -->
			<table>
			
				<tr>
				 	<th>Transport Type Name</th>
				 	<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempTransportType" items="${transportTypes}">
					
					<!-- construct an "update" link with country id -->
					<c:url var="updateLink" value="/user/updateTransportTypeForm">
						<c:param name="transportTypeId" value="${tempTransportType.transportTypeId}" />
					</c:url>
					
					<!-- construct an "delete" link with country id -->
					<c:url var="deleteLink" value="/user/deleteTransportType">
						<c:param name="transportTypeId" value="${tempTransportType.transportTypeId}" />
					</c:url>
					
					<tr> 
						<td> ${tempTransportType.transportTypeName} </td>
					
						<td> 
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<!-- display the delete link -->
							<a href="${deleteLink}"
							   onclick="if(!(confirm('Are you sure you want to delete this Transport Type?'))) return false">Delete</a>
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