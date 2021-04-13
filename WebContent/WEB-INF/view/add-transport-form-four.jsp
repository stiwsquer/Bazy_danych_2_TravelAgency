<!-- Add suport for jstl core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title> Select Transport Type</title>

	<!-- reference our style sheet -->
	<link type = "text/css"
		  rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>
	
	<div id = "wrapper">
		<div id="header">
			<h2>Travel Agency - Select The Transport Type Of The Transport</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<h3>Select Transport Type:</h3>
			
			<!-- add our html table here -->
			<table>
			
				<tr>
				 	<th>Transport Type Name </th>
				 	<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempTransportType" items="${transportTypes}">
					
					<!-- construct an "update" link with country id -->
					<c:url var="selectLink" value="/user/processAddTransportFormFour">
						<c:param name="transportTypeId" value="${tempTransportType.transportTypeId}" />
					</c:url>
					
					
					
					<tr> 
						<td> ${tempTransportType.transportTypeName} </td>
					
						<td> 
							<!-- display the select link -->
							<a href="${selectLink}">Select</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			<div style = "clear; both;" >  </div>
			<p> 
				<a href="${pageContext.request.contextPath}/user/addTransportFormOne">Back to start</a>
			</p>
		</div>
	</div>
	
</body>
</html>